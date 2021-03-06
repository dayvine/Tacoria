package com.davidvinegar.tacoria.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.davidvinegar.tacoria.Model.Bag;
import com.davidvinegar.tacoria.R;
import com.simplify.android.sdk.Card;
import com.simplify.android.sdk.CardEditor;
import com.simplify.android.sdk.CardToken;
import com.simplify.android.sdk.Simplify;

/**
 * Created by davidvinegar on 1/6/17.
 */
public class CreditCardInputActivity extends Activity{
    private Button buttonAuthorize;
    Simplify simplify;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.getcreditcard_layout);

        simplify = new Simplify();
        simplify.setApiKey("sbpb_OWIyYzA1YzAtNzBjMC00NDgyLTgwZGQtNGRiZTQzODM3YWE3");

        Card card = new Card()
                .setNumber("5555555555554444")
                .setExpMonth("01")
                .setExpYear("99")
                .setCvc("123")
                .setAddressZip("12345");

        simplify.createCardToken(card, new CardToken.Callback() {
            @Override
            public void onSuccess(CardToken cardToken) {

            }

            @Override
            public void onError(Throwable throwable) {

            }
        });


        final CardEditor cardEditor = (CardEditor)findViewById(R.id.card_editor);
        final Button checkoutButton = (Button) findViewById(R.id.checkout_button);

        cardEditor.addOnStateChangedListener(new CardEditor.OnStateChangedListener() {
            @Override
            public void onStateChange(CardEditor cardEditor) {
                checkoutButton.setEnabled(cardEditor.isValid());
            }
        });

        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simplify.createCardToken(cardEditor.getCard(), new CardToken.Callback(){
                    @Override
                public void onSuccess(CardToken cardToken){

                        // TODO Here is where you would send the token ID and payment information back to your server for processing...
                        Intent intent = new Intent(getApplicationContext(),ThankYouActivity.class);

                        Bag bag = Bag.getInstance();
                        bag.clearOrderables();

                        startActivity(intent);

                    }

                    @Override
                public void onError(Throwable throwable){

                    }
                });
            }
        });
    }






}
