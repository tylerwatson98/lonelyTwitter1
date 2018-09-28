package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	// if something is static that means it extends across the entire program
	// if something is final that means it is constant, you don't want to change it
	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;

	
	/** Called when the activity is first created. */
	@Override
	// onCreate sets the layout of everything for the views so it doesn't have to be done later
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		bodyText = findViewById(R.id.body);
		Button saveButton = findViewById(R.id.save);
		oldTweetsList = findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// getting the text
				String text = bodyText.getText().toString();

				// creating an instance of the class
				ImportantTweet newTweet = new ImportantTweet();

				// set message of the new tweet
				try {
					newTweet.setMessage(text);
					newTweet.setDate(new Date());

					tweets.add(newTweet);
					adapter.notifyDataSetChanged();
					saveInFile();

				} catch (MaxTextLength maxTextLength) {
					maxTextLength.printStackTrace();
				}
			}
		});
	}

	// when you override a method the first thing you should write is super."method"
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweets);
		// once the adapter is set the list will be displayed in that view
		oldTweetsList.setAdapter(adapter);
	}

	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader reader = new BufferedReader(isr);
			Gson gson = new Gson();
			Type listTweetType = new TypeToken<ArrayList<ImportantTweet>>(){}.getType();
			gson.fromJson(reader,listTweetType);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweets=new ArrayList<Tweet>();
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void saveInFile() {
		try {

			// saving a file with gson
			FileOutputStream fos = openFileOutput(FILENAME,0);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter writer = new BufferedWriter(osw);
			Gson gson = new Gson();
			gson.toJson(tweets,writer);
			writer.flush();
			fos.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}