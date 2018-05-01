package com.example.rishipandey125.quoteapp;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.HashMap;

/**
 * MAINACTIVITY CLASS FOR ALL FUNCTIONS. This app is as quote generator based off of certain feelings, that has text to speech capabilities.
 */
public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener, TextToSpeech.OnUtteranceCompletedListener {
    /**
     * START OF QUOTES.
     */
    String[] motivationQuotes = {"The Way Get Started Is To Quit Talking And Begin Doing. – Walt Disney",
            "Hard work beats talent when talent doesn’t work hard. - Tim Notke",
            "Failure will never overtake me if my determination to succeed is strong enough. - Og Mandino",
            "Aim for the moon. If you miss, you may hit a star. - W. Clement Stone",
            "Action is the foundational key to all success. - Pablo Picasso",
            "Successful people do what unsuccessful people are not willing to do. Don’t wish it were easier, wish you were better. - Jim Rohn",
            "It does not matter how slowly you go, so long as you do not stop. - Confucius",
            "It's YOU vs. YOU. - Paul Vandersteen",
            "Do or do not. There is no try. - YODA",
            "I'm loyal to nothing except the dream. - Steve Rodgers (Captain America)",
            "I find that the harder I work, the more luck I seem to have - Thomas Jefferson",
            "Life begins at the end of your comfort zone. - Neale Donald Walsh",
            "Success is walking from failure to failure with no loss of enthusiasm. - Winston Churchill",
            "Opportunities don’t happen, you create them. -Chris Grosser",
            "Don’t watch the clock; do what it does. Keep going. - Sam Levenson"};
    String[] sadQuotes = {"The word 'happy' would lose its meaning if it were not balanced by sadness.- Carl Jung",
                            "It's sad when someone you know becomes someone you knew. - Henry Rollins",
                            "The good times of today, are the sad thoughts of tomorrow. - Bob Marley",
                            "Tears come from the heart and not from the brain. - Leonardo da Vinci",
                            "It's amazing how one little conversation can change things forever. - Hefty Guy",
                            "Somethings will always just be unfinished business. - Chuck Wendig",
                            "New beginnings are often disguised as painful endings. - Dia Laura",
                            "Nothing is more sad than the death of an illusion. - Arthur Koestler",
                            "Nobody understands another's sorry, and nobody another's joy. - Francz Shubert",
                            "A sad soul can kill quicker than a germ. - John Steinbeck",
                            "One must not let oneself be overwhelmed by sadness. - Jackie Kennedy",
                            "Delicious tears! The heart's own dew. - Letitia Elizabeth Landon",
                            "I could do this all day. - Steve Rodgers (Captain America)",
                            "No one wants a legend, they just turn into a burden. - Luke Skywalker",
                            "I am a monster, but at least I know it and have accepted it. - Kylo Ren"};
    String[] happyQuotes = {"Don't cry because it's over, smile because it happened. - Dr. Seuss",
                            "For every minute you are angry you lose sixzty seconds of happiness. - Ralph Waldo Emerson",
                            "Count your age by friends, not years. Count your life by smiles, not tears. - John Lennon",
                            "Be happy for this moment. This moment is your life. - Omar Khayyam",
                            "Do not take life so seriously. You will never get out of it alive. - Elbert Hubbard",
                            "Life is like a rollercoaster, live it, be happy, enjoy life. - Avil Lavigne",
                            "Behind every great man is a woman rolling her eyes. - Jim Carrey",
                            "I am one with the force, the force is with me. - Chirrut Imwae",
                            "Do you ever feel like a plastic bag, drifting through the wind, trying to start again?",
                            "I am just an ICON livin. - Jaden Smith",
                            "Be the change you wish to see in the world. - Mahatama Gandhi",
                            "The art of being happy lies in the power of extracting happiness from common things - Henry Ward Beecher",
                            "We all live with the objective of being happy, our lives are all different and yet the same. - Anne Frank",
                            "We will we the spark, that will light the fire! - Poe Dameron",
                            "Nobody really cares if you're miserable, so you might as well be happy - Cynthia Nelms"};
    /**
     * END OF QUOTES.
     */
    /**
     * CREATION OF TEXT TO SPEECH BASED OFF OF LIBRARY CONSTRUCTOR.
     */
    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textToSpeech = new TextToSpeech(MainActivity.this, MainActivity.this);
        /**
         * CREATION OF BUTTONS.
         */
        final Button happyButton = (Button) findViewById(R.id.happy);
        final Button sadButton = (Button) findViewById(R.id.sad);
        final Button motivationButton = (Button) findViewById(R.id.motivation);
        final TextView quoteOutput = (TextView) findViewById(R.id.quote);
        /**
         * ON CLICK FUNCTIONS FOR MOTIVATION BUTTON.
         */
        motivationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!textToSpeech.isSpeaking()) {
                    String[] tempList = motivationQuotes;
                    int randoLength = tempList.length + 1;
                    int rando = (int) Math.floor((Math.random() * randoLength));
                    String temp = tempList[rando];
                    quoteOutput.setText(temp);
                    HashMap<String, String> stringStringHashMap = new HashMap<String, String>();
                    stringStringHashMap.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "");
                    textToSpeech.speak(quoteOutput.getText().toString(), TextToSpeech.QUEUE_ADD, stringStringHashMap);
                    motivationButton.setVisibility(Button.GONE);
                } else {
                    textToSpeech.stop();
                }
            }
        });
        /**
         * ON CLICK FUNCTIONS FOR SAD BUTTON.
         */
        sadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!textToSpeech.isSpeaking()) {
                    String[] tempList = sadQuotes;
                    int randoLength = tempList.length + 1;
                    int rando = (int) Math.floor((Math.random() * randoLength));
                    String temp = tempList[rando];
                    quoteOutput.setText(temp);
                    HashMap<String, String> stringStringHashMap = new HashMap<String, String>();
                    stringStringHashMap.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "");
                    textToSpeech.speak(quoteOutput.getText().toString(), TextToSpeech.QUEUE_ADD, stringStringHashMap);
                    sadButton.setVisibility(Button.GONE);
                } else {
                    textToSpeech.stop();
                }
            }
        });
        /**
         * ON CLICK FUNCTIONS FOR HAPPY BUTTON.
         */
        happyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!textToSpeech.isSpeaking()) {
                    String[] tempList = happyQuotes;
                    int randoLength = tempList.length + 1;
                    int rando = (int) Math.floor((Math.random() * randoLength));
                    String temp = tempList[rando];
                    quoteOutput.setText(temp);
                    HashMap<String, String> stringStringHashMap = new HashMap<String, String>();
                    stringStringHashMap.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "");
                    textToSpeech.speak(quoteOutput.getText().toString(), TextToSpeech.QUEUE_ADD, stringStringHashMap);
                    happyButton.setVisibility(Button.GONE);
                } else {
                    textToSpeech.stop();
                }
            }
        });
    }


    @Override
    public void onInit(int status) {
        textToSpeech.setOnUtteranceCompletedListener(this);
    }

    /**
     * BUTTON CONNECTIONS.
     * @param utteranceId VALUES FOR BUTTON IDENTIFICATION.
     */
    @Override
    public void onUtteranceCompleted(String utteranceId) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "SPEAKING ON", Toast.LENGTH_LONG).show();
                Button button = (Button) findViewById(R.id.happy);
                Button button1 = (Button) findViewById(R.id.sad);
                Button button2 = (Button) findViewById(R.id.motivation);
                button.setVisibility(Button.VISIBLE);
                button1.setVisibility(Button.VISIBLE);
                button2.setVisibility(Button.VISIBLE);
            }
        }); {

        }
    }

    /**
     * APP EXIT.
     */
    protected void onDestroy() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
            textToSpeech = null;
        }
        super.onDestroy();
    }
}
