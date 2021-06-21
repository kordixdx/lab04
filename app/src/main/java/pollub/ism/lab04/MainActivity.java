package pollub.ism.lab04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    boolean czyKrzyzyk = true;
    char[][] plansza = new char[3][3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void kliknieciePrzycisku(View view){
        Button przycisk = (Button) findViewById(view.getId());
        TextView tekstWygrana = (TextView) findViewById(R.id.tekstWygrana);
        przycisk.setText(XO());
        przycisk.setClickable(false);
        tworzeniePlanszy(view,czyKrzyzyk,plansza);
        tekstWygrana.setText(wygrana(view,plansza));
        if(tekstWygrana.getText()!=""){

        }
    }

    public String XO(){
        if(czyKrzyzyk){
            czyKrzyzyk=!czyKrzyzyk;
            return "X";
        }
        else{
            czyKrzyzyk=!czyKrzyzyk;
            return "O";
        }
    }
    public void tworzeniePlanszy(View view, boolean czyKrzyzyk, char[][] plansza) {
        String nazwaPrzycisku = view.getResources().getResourceEntryName(view.getId());
        String[] czesc = nazwaPrzycisku.split("_");
        int a = Integer.parseInt(czesc[1]);
        int b = Integer.parseInt(czesc[2]);

        if (!czyKrzyzyk) {
            plansza[a - 1][b - 1] = 'X';
        } else {
            plansza[a - 1][b - 1] = 'O';
        }
    }
    public String wygrana(View view, char plansza[][]){


        for(int i=0;i<3;i++) {
            if (plansza[i][0]==plansza[i][1] && plansza[i][1]==plansza[i][2] && plansza[i][0]=='X' || plansza[0][i]==plansza[1][i] && plansza[1][i]==plansza[2][i] && plansza[0][i]=='X') {
                return "Wygrały Krzyżyki";
            }
        }

        if(plansza[0][0]==plansza[1][1] && plansza[1][1]==plansza[2][2] && plansza[0][0]=='X' || plansza[0][2]==plansza[1][1] && plansza[1][1]==plansza[2][0] && plansza[0][2]=='X'){
            return "Wygrały Krzyżyki";
        }

        for(int j=0;j<3;j++) {
            if (plansza[j][0] == plansza[j][1] && plansza[j][1] == plansza[j][2] && plansza[j][0] == 'O' || plansza[0][j] == plansza[1][j] && plansza[1][j] == plansza[2][j] && plansza[0][j] == 'O'){
                return "Wygrały Kółka";
        }
        }

        if(plansza[0][0]==plansza[1][1] && plansza[1][1]==plansza[2][2] && plansza[0][0]=='O' || plansza[0][2]==plansza[1][1] && plansza[1][1]==plansza[2][0] && plansza[0][2]=='O' ){
            return "Wygrały Kółka";
        }
        return "";
    }

}