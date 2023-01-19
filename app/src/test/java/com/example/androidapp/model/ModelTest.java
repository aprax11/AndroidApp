package com.example.androidapp.model;


import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.androidapp.containers.IChallenge;
import com.example.androidapp.containers.IParticipant;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RunWith(MockitoJUnitRunner.class)

public class ModelTest {

    public final String GETALLSCRIPTLOCATION = "http://10.0.2.2/androidBelegPhpScript/getAll.php";
    public final String GETPARTICIPANTSSCRIPTLOCATION = "http://10.0.2.2/androidBelegPhpScript/getParticipants.php";
    public final String ADDPRTICIPATIONSCRIPTLOCATION = "http://10.0.2.2/androidBelegPhpScript/addParticipation.php";
    public final String ADDCHALLENGESCRIPTLOCATION = "http://10.0.2.2/androidBelegPhpScript/addChallenge.php";

    public final String PARTICIPANTNAME = "testParticipant";
    public final String PARTICIPANTSCORE = "10";

    public final String CHALLENGENAME = "testChallenge";
    public final String CHALLENGEDESCRIPTION = "This is a test description";
    public final String CHALLENGEID = "1";

    public IModel model = Model.getInstance();


    @Test
    public void getSetAsyncTaskWrapperTest(){
        IAsyncTaskWrapper asyncTaskWrapper = mock(AsyncTaskWrapper.class);

        model.setAsyncTaskWrapper(asyncTaskWrapper);

        Assert.assertEquals(asyncTaskWrapper, model.getAsyncTaskWrapper());
    }
    @Test
    public void addChallenge_Test() throws UnsupportedEncodingException, ExecutionException, InterruptedException {
        IAsyncTaskWrapper asyncTaskWrapper = mock(AsyncTaskWrapper.class);

        model.setAsyncTaskWrapper(asyncTaskWrapper);
        model.addChallenge(CHALLENGENAME, CHALLENGEDESCRIPTION);

        String url = URLEncoder.encode("challengeName", "UTF-8")+"="+URLEncoder.encode(CHALLENGENAME, "UTF-8")+"&"
                +URLEncoder.encode("challengeDescription", "UTF-8")+"="+URLEncoder.encode(CHALLENGEDESCRIPTION, "UTF-8");

        verify(asyncTaskWrapper).startAsyncTask(ADDCHALLENGESCRIPTLOCATION, url);
    }
    @Test
    public void addParticipant_Test() throws UnsupportedEncodingException, ExecutionException, InterruptedException {
        IAsyncTaskWrapper asyncTaskWrapper = mock(AsyncTaskWrapper.class);

        model.setAsyncTaskWrapper(asyncTaskWrapper);

        model.addParticipation(PARTICIPANTNAME, PARTICIPANTSCORE, CHALLENGEID);

        String url = URLEncoder.encode("participantName", "UTF-8")+"="+URLEncoder.encode(PARTICIPANTNAME, "UTF-8")+"&"
                +URLEncoder.encode("score", "UTF-8")+"="+URLEncoder.encode(PARTICIPANTSCORE, "UTF-8")+"&"
                +URLEncoder.encode("challengeId", "UTF-8")+"="+URLEncoder.encode(CHALLENGEID, "UTF-8");

        verify(asyncTaskWrapper).startAsyncTask(ADDPRTICIPATIONSCRIPTLOCATION, url);
    }
    @Test
    public void getParticipants_Test() throws ExecutionException, InterruptedException {
        IAsyncTaskWrapper asyncTaskWrapper = mock(AsyncTaskWrapper.class);

        model.setAsyncTaskWrapper(asyncTaskWrapper);

        when(asyncTaskWrapper.startAsyncTask(anyString(), anyString())).thenReturn(PARTICIPANTNAME+"`"+PARTICIPANTSCORE+"~");
        ArrayList<IParticipant> ret = model.getParticipants(CHALLENGEID);

        Assert.assertEquals(PARTICIPANTNAME, ret.get(0).getName());
        Assert.assertEquals(PARTICIPANTSCORE, ret.get(0).getScore());
    }
    @Test
    public void getParticipantsUsesCorrectPhpFile_Test() throws UnsupportedEncodingException, ExecutionException, InterruptedException {
        IAsyncTaskWrapper asyncTaskWrapper = mock(AsyncTaskWrapper.class);

        model.setAsyncTaskWrapper(asyncTaskWrapper);

        when(asyncTaskWrapper.startAsyncTask(anyString(), anyString())).thenReturn(PARTICIPANTNAME+"`"+PARTICIPANTSCORE+"~");
        ArrayList<IParticipant> ret = model.getParticipants(CHALLENGEID);

        String url = URLEncoder.encode("phpType", "UTF-8")+"="+URLEncoder.encode("getParticipants", "UTF-8")+"&"
                +URLEncoder.encode("id", "UTF-8")+"="+URLEncoder.encode(CHALLENGEID, "UTF-8");

        verify(asyncTaskWrapper).startAsyncTask(GETPARTICIPANTSSCRIPTLOCATION, url);
    }
    @Test
    public void getAllChallenges_Test() throws ExecutionException, InterruptedException {
        IAsyncTaskWrapper asyncTaskWrapper = mock(AsyncTaskWrapper.class);

        model.setAsyncTaskWrapper(asyncTaskWrapper);

        when(asyncTaskWrapper.startAsyncTask(anyString(), anyString())).thenReturn(CHALLENGENAME+"`"+CHALLENGEID+"`"+CHALLENGEDESCRIPTION+"~");
        List<IChallenge> ret = model.getAllChallenges();

        Assert.assertEquals(CHALLENGENAME, ret.get(0).getName());
        Assert.assertEquals(CHALLENGEID, ret.get(0).getId());
        Assert.assertEquals(CHALLENGEDESCRIPTION, ret.get(0).getDescription());
    }
    @Test
    public void getAllUsesCorrectPhpFile_Test() throws UnsupportedEncodingException, ExecutionException, InterruptedException {
        IAsyncTaskWrapper asyncTaskWrapper = mock(AsyncTaskWrapper.class);

        model.setAsyncTaskWrapper(asyncTaskWrapper);

        when(asyncTaskWrapper.startAsyncTask(anyString(), anyString())).thenReturn(CHALLENGENAME+"`"+CHALLENGEID+"`"+CHALLENGEDESCRIPTION+"~");
        List<IChallenge> ret = model.getAllChallenges();

        String url = URLEncoder.encode("phpType", "UTF-8")+"="+URLEncoder.encode("getAll", "UTF-8");

        verify(asyncTaskWrapper).startAsyncTask(GETALLSCRIPTLOCATION, url);
    }
    @Test
    public void exitIfChallengeNameIsEmpty_Test() throws ExecutionException, InterruptedException {
        IAsyncTaskWrapper asyncTaskWrapper = mock(AsyncTaskWrapper.class);

        model.setAsyncTaskWrapper(asyncTaskWrapper);

        String ret = model.addChallenge("", "test");

        verify(asyncTaskWrapper, never()).startAsyncTask(anyString(), anyString());

        Assert.assertEquals("1", ret);
    }
    @Test
    public void exitIfChallengeDescriptionIsEmpty_Test() throws ExecutionException, InterruptedException {
        IAsyncTaskWrapper asyncTaskWrapper = mock(AsyncTaskWrapper.class);

        model.setAsyncTaskWrapper(asyncTaskWrapper);

        String ret = model.addChallenge("test", "");

        verify(asyncTaskWrapper, never()).startAsyncTask(anyString(), anyString());

        Assert.assertEquals("1", ret);
    }

    @Test
    public void exitIfChallengeBothStringsIsEmpty_Test() throws ExecutionException, InterruptedException {
        IAsyncTaskWrapper asyncTaskWrapper = mock(AsyncTaskWrapper.class);

        model.setAsyncTaskWrapper(asyncTaskWrapper);

        String ret = model.addChallenge("", "");

        verify(asyncTaskWrapper, never()).startAsyncTask(anyString(), anyString());

        Assert.assertEquals("1", ret);
    }
    @Test
    public void exitIfParticipationNameIsEmpty_Test() throws ExecutionException, InterruptedException {
        IAsyncTaskWrapper asyncTaskWrapper = mock(AsyncTaskWrapper.class);

        model.setAsyncTaskWrapper(asyncTaskWrapper);

        String ret = model.addParticipation("", "testS","4");

        verify(asyncTaskWrapper, never()).startAsyncTask(anyString(), anyString());

        Assert.assertEquals("1", ret);
    }
    @Test
    public void exitIfParticipationScoreIsEmpty_Test() throws ExecutionException, InterruptedException {
        IAsyncTaskWrapper asyncTaskWrapper = mock(AsyncTaskWrapper.class);

        model.setAsyncTaskWrapper(asyncTaskWrapper);

        String ret = model.addParticipation("testP", "","4");

        verify(asyncTaskWrapper, never()).startAsyncTask(anyString(), anyString());

        Assert.assertEquals("1", ret);
    }
    @Test
    public void exitIfParticipationBothStringsIsEmpty_Test() throws ExecutionException, InterruptedException {
        IAsyncTaskWrapper asyncTaskWrapper = mock(AsyncTaskWrapper.class);

        model.setAsyncTaskWrapper(asyncTaskWrapper);

        String ret = model.addParticipation("", "", "4");

        verify(asyncTaskWrapper, never()).startAsyncTask(anyString(), anyString());

        Assert.assertEquals("1", ret);
    }

}
