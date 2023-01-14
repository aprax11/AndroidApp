package com.example.androidapp.control;


import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.androidapp.model.IChallenge;
import com.example.androidapp.model.IParticipant;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)

public class ControlTest {

    public final String GETALLSCRIPTLOCATION = "http://10.0.2.2/androidBelegPhpScript/getAll.php";
    public final String GETPARTICIPANTSSCRIPTLOCATION = "http://10.0.2.2/androidBelegPhpScript/getParticipants.php";
    public final String ADDPRTICIPATIONSCRIPTLOCATION = "http://10.0.2.2/androidBelegPhpScript/addParticipation.php";
    public final String ADDCHALLENGESCRIPTLOCATION = "http://10.0.2.2/androidBelegPhpScript/addChallenge.php";

    public final String PARTICIPANTNAME = "testParticipant";
    public final String PARTICIPANTSCORE = "10";

    public final String CHALLENGENAME = "testChallenge";
    public final String CHALLENGEDESCRIPTION = "This is a test description";
    public final String CHALLENGEID = "1";

    @Test
    public void addChallenge_Test() throws UnsupportedEncodingException {
        IControl control = new Control();
        Network mockNetwork = Mockito.mock(Network.class);
       control.addChallenge(CHALLENGENAME, CHALLENGEDESCRIPTION, new Network());

        String url = URLEncoder.encode("challengeName", "UTF-8")+"="+URLEncoder.encode(CHALLENGENAME, "UTF-8")+"&"
                +URLEncoder.encode("challengeDescription", "UTF-8")+"="+URLEncoder.encode(CHALLENGEDESCRIPTION, "UTF-8");

        verify(mockNetwork).doInBackground(ADDCHALLENGESCRIPTLOCATION, url);
    }
    @Test
    public void addParticipant_Test() throws UnsupportedEncodingException {
        IControl control = new Control();
        Network mockNetwork = Mockito.mock(Network.class);
        control.addParticipation(PARTICIPANTNAME, PARTICIPANTSCORE, CHALLENGEID, mockNetwork);

        String url = URLEncoder.encode("participantName", "UTF-8")+"="+URLEncoder.encode(PARTICIPANTNAME, "UTF-8")+"&"
                +URLEncoder.encode("score", "UTF-8")+"="+URLEncoder.encode(PARTICIPANTSCORE, "UTF-8")+"&"
                +URLEncoder.encode("challengeId", "UTF-8")+"="+URLEncoder.encode(CHALLENGEID, "UTF-8");

        verify(mockNetwork).doInBackground(ADDPRTICIPATIONSCRIPTLOCATION, url);
    }
    @Test
    public void getParticipants_Test(){
        IControl control = new Control();
        Network mockNetwork = Mockito.mock(Network.class);

        when(mockNetwork.doInBackground(anyString(), anyString())).thenReturn(PARTICIPANTNAME+"`"+PARTICIPANTSCORE+"~");
        ArrayList<IParticipant> ret = control.getParticipants(CHALLENGEID, mockNetwork);

        Assert.assertEquals(PARTICIPANTNAME, ret.get(0).getName());
        Assert.assertEquals(PARTICIPANTSCORE, ret.get(0).getScore());
    }
    @Test
    public void getParticipantsUsesCorrectPhpFile_Test() throws UnsupportedEncodingException {
        IControl control = new Control();
        Network mockNetwork = Mockito.mock(Network.class);

        ArrayList<IParticipant> ret = control.getParticipants(CHALLENGEID, mockNetwork);

        String url = URLEncoder.encode("phpType", "UTF-8")+"="+URLEncoder.encode("getParticipants", "UTF-8")+"&"
                +URLEncoder.encode("id", "UTF-8")+"="+URLEncoder.encode(CHALLENGEID, "UTF-8");

        verify(mockNetwork).doInBackground(GETPARTICIPANTSSCRIPTLOCATION, url);
    }
    @Test
    public void getAll_Test(){
        IControl control = new Control();
        Network mockNetwork = Mockito.mock(Network.class);

        when(mockNetwork.doInBackground(anyString(), anyString())).thenReturn(CHALLENGENAME+"`"+CHALLENGEID+"`"+CHALLENGEDESCRIPTION+"~");
        List<IChallenge> ret = control.getAll(mockNetwork);

        Assert.assertEquals(CHALLENGENAME, ret.get(0).getName());
        Assert.assertEquals(CHALLENGEID, ret.get(0).getId());
        Assert.assertEquals(CHALLENGEDESCRIPTION, ret.get(0).getDescription());
    }
    @Test
    public void getAllUsesCorrectPhpFile_Test() throws UnsupportedEncodingException {
        IControl control = new Control();
        Network mockNetwork = Mockito.mock(Network.class);

        List<IChallenge> ret = control.getAll(mockNetwork);

        String url = URLEncoder.encode("phpType", "UTF-8")+"="+URLEncoder.encode("getAll", "UTF-8");

        verify(mockNetwork).doInBackground(GETALLSCRIPTLOCATION, url);
    }

}
