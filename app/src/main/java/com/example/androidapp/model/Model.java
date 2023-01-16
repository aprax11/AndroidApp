package com.example.androidapp.model;

import com.example.androidapp.containers.Challenge;
import com.example.androidapp.containers.IChallenge;
import com.example.androidapp.containers.IParticipant;
import com.example.androidapp.containers.Participant;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Model implements IModel, Serializable {
    private IAsyncTaskWrapper asyncTaskWrapper;

    private Model(){
        asyncTaskWrapper = new AsyncTaskWrapper();
    }
    private  static Model instance;
    public static Model getInstance(){
        if(instance == null) {
            instance = new Model();
        }
        return instance;
    }

    @Override
    public List<IChallenge> getAll(){
        try {
            String url = URLEncoder.encode("phpType", "UTF-8")+"="+URLEncoder.encode("getAll", "UTF-8");
            String res = asyncTaskWrapper.startAsyncTask("http://10.0.2.2/androidBelegPhpScript/getAll.php", url);


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

    @Override
    public ArrayList<IParticipant> getParticipants(String id){
        try {
            String url = URLEncoder.encode("phpType", "UTF-8")+"="+URLEncoder.encode("getParticipants", "UTF-8")+"&"
                +URLEncoder.encode("id", "UTF-8")+"="+URLEncoder.encode(id, "UTF-8");
            String res = asyncTaskWrapper.startAsyncTask("http://10.0.2.2/androidBelegPhpScript/getParticipants.php", url);
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
        } catch (UnsupportedEncodingException  e) {
            e.printStackTrace();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public String addParticipation(String participantName, String score, String challengeId){
        if(participantName.isEmpty() || score.isEmpty() || challengeId.isEmpty()){
            return "1";
        }
        try{
            String url = URLEncoder.encode("participantName", "UTF-8")+"="+URLEncoder.encode(participantName, "UTF-8")+"&"
                    +URLEncoder.encode("score", "UTF-8")+"="+URLEncoder.encode(score, "UTF-8")+"&"
                    +URLEncoder.encode("challengeId", "UTF-8")+"="+URLEncoder.encode(challengeId, "UTF-8");
            String res = asyncTaskWrapper.startAsyncTask("http://10.0.2.2/androidBelegPhpScript/addParticipation.php", url);

            return res;
        }catch(IOException  e){
            e.printStackTrace();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "";
    }
    @Override
    public String addChallenge(String challengeName, String challengeDescription){
        if(challengeName.isEmpty() || challengeDescription.isEmpty()){
            return "1";
        }

        try{
            String url = URLEncoder.encode("challengeName", "UTF-8")+"="+URLEncoder.encode(challengeName, "UTF-8")+"&"
                    +URLEncoder.encode("challengeDescription", "UTF-8")+"="+URLEncoder.encode(challengeDescription, "UTF-8");
            String res = asyncTaskWrapper.startAsyncTask("http://10.0.2.2/androidBelegPhpScript/addChallenge.php", url);

            return res;
        }catch(IOException  e){
            e.printStackTrace();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "";
    }



    private List<String[]> parseString(String res){
        res.trim();
        String[] rows = res.split("~");

        List<String[]>trimmed = new LinkedList<>();
        for (String ele : rows) {
            trimmed.add(ele.split("`"));
            /*
            for (String elem : ele.split("`")
            ) {
            }

             */
        }
        return trimmed;
    }

    @Override
    public IAsyncTaskWrapper getAsyncTaskWrapper() {
        return asyncTaskWrapper;
    }
    @Override
    public void setAsyncTaskWrapper(IAsyncTaskWrapper asyncTaskWrapper) {
        this.asyncTaskWrapper = asyncTaskWrapper;
    }
}
