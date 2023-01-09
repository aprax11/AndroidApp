package com.example.androidapp.control;

import android.util.Log;

import com.example.androidapp.model.Challenge;
import com.example.androidapp.model.IChallenge;
import com.example.androidapp.model.IParticipant;
import com.example.androidapp.model.Participant;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Control {
    Network network = new Network();

    public List<IChallenge> getAll(){
        try {
            String url = URLEncoder.encode("phpType", "UTF-8")+"="+URLEncoder.encode("getAll", "UTF-8");
            String res = network.execute("http://10.0.2.2/androidBelegPhpScript/getAll.php", url).get();


            List<IChallenge> list = new ArrayList<>();
            List<String[]> trimmed = parseString(res);
            for (String[] challenge: trimmed
                 ) {
                IChallenge challengeObject = new Challenge();
                challengeObject.setName(challenge[0]);
                challengeObject.setId(challenge[1]);
                challengeObject.setDescription(challenge[2]);
                list.add(challengeObject);
            }


            return list;
        } catch (UnsupportedEncodingException | ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<IParticipant> getParticipants(String id){

        try {
            String url = URLEncoder.encode("phpType", "UTF-8")+"="+URLEncoder.encode("getParticipants", "UTF-8")+"&"
                +URLEncoder.encode("id", "UTF-8")+"="+URLEncoder.encode(id, "UTF-8");
            String res = network.execute("http://10.0.2.2/androidBelegPhpScript/getParticipants.php", url).get();
            ArrayList<IParticipant> list = new ArrayList<>();
            if(!res.equals("noResult")){
                List<String[]> trimmed = parseString(res);
                for (String[] challenge: trimmed
                ) {
                    if(challenge.length==2){
                        IParticipant participantObject = new Participant();
                        participantObject.setName(challenge[0]);
                        participantObject.setScore(challenge[1]);

                        list.add(participantObject);
                    }
                }
            }

            return list;
        } catch (UnsupportedEncodingException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String addParticipation(String participantName, String score, String challengeId){
        try{
            String url = URLEncoder.encode("participantName", "UTF-8")+"="+URLEncoder.encode(participantName, "UTF-8")+"&"
                    +URLEncoder.encode("score", "UTF-8")+"="+URLEncoder.encode(score, "UTF-8")+"&"
                    +URLEncoder.encode("challengeId", "UTF-8")+"="+URLEncoder.encode(challengeId, "UTF-8");
            String res = network.execute("http://10.0.2.2/androidBelegPhpScript/addParticipation.php", url).get();
            Log.d("Control", challengeId);
            Log.d("Control", res);
            return res;
        }catch(IOException | ExecutionException | InterruptedException e){
            e.printStackTrace();
        }
        return "";
    }
    public String addChallenge(String challengeName, String challengeDescription){
        try{
            String url = URLEncoder.encode("challengeName", "UTF-8")+"="+URLEncoder.encode(challengeName, "UTF-8")+"&"
                    +URLEncoder.encode("challengeDescription", "UTF-8")+"="+URLEncoder.encode(challengeDescription, "UTF-8");
            String res = network.execute("http://10.0.2.2/androidBelegPhpScript/addChallenge.php", url).get();

            return res;
        }catch(IOException | ExecutionException | InterruptedException e){
            e.printStackTrace();
        }
        return "";
    }
/*
    public static Control getNewInsatnce(){
        return new Control();
    }

 */


    private List<String[]> parseString(String res){
        res.trim();
        String[] rows = res.split("~");
        Log.d("tag", String.valueOf(rows.length));

        List<String[]>trimmed = new LinkedList<>();
        for (String ele : rows) {
            trimmed.add(ele.split(","));
            for (String elem : ele.split(",")
            ) {
                Log.d("network", elem);
            }
        }
        return trimmed;
    }
}
