package com.example.studying.studies.lesson8;

import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableField;
import android.os.AsyncTask;
import android.util.Log;

import com.example.studying.studies.base.BaseViewModel;
import com.example.studying.studies.dz4.Dz4Activity;

public class Lesson8ViewModel implements BaseViewModel {

    public Activity activity;
    public ObservableField<String> helloText = new ObservableField<>("Hello");

    public Lesson8ViewModel(Activity activity){
        this.activity = activity;
    }

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    public void onSuperButtonClick(){
        Log.e("DDD", "OnButtonClick");
        /*Intent intent = new Intent(activity, Dz4Activity.class);
        activity.startActivity(intent);*/
    }

    public class MyAsyncTask extends AsyncTask<Void, Integer, String>{

        //Чтобы запустить - делаем новый экземпляр класса и делаем старт

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //выпонянется до начала метода doInBackground,  в UI потоке
            //первым, как вызвали старт.
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            //выполняется в юай потоке,
            // но вызывать его нужно самостоятельно из doInBackground
        }

        @Override
        protected String doInBackground(Void... voids) {
            //весь код здесь выполнится в другом потоке
            // затем передает эти данные в метод onPostExecute

            publishProgress(20); //вызывается onProgressUpdate
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //выполнится уже в ui потоке
            //входное значение передаетмя из метода doInBackground
        }
    }

}
