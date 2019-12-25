package egitim.uniyaz;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Tahta extends VerticalLayout {

    HorizontalLayout hLayout;
    Random rand = new Random();
    int btnSize = 0;
    int[][] btnDizi;
    List<Button> buttonList;

    public Tahta(int btnSayi) {

        setMargin(true);
        createButtons(btnSayi);
//        for (int i = 0; i <btnSayi; i++) {
//            hLayout = new HorizontalLayout();
//            for (int j = 0; j <btnSayi ; j++) {
//                btn = new Button();
//                hLayout.addComponent(btn);
//                addComponent(hLayout);
//            }
//
//        }
    }

    private void createButtons(int btnSayi) {
        buttonList=new ArrayList<Button>();
        btnDizi = new int[btnSayi+1][btnSayi+1];
        btnSize = btnSayi;
        for (int i = 1; i <= btnSayi; i++) {
            hLayout = new HorizontalLayout();

            for (int j = 1; j <= btnSayi ; j++) {
                int rnd= rand.nextInt(2);
                Button btn = new Button();
                btn.setData(rnd);
                btn.setDescription(String.valueOf(rnd)); // buton değerlerini test etmek için
              //  btn.setCaption(String.valueOf(rnd));
                int ii = i;
                int jj = j;

                btnDizi[ii][jj] = rnd;
                btn.addClickListener(new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent clickEvent) {

                        aliveButtons(ii,jj,btn);
                    }
                });
                hLayout.addComponent(btn);
                addComponent(hLayout);
            }

        }
    }

    private void aliveButtons(int i,int j,Button btn) {
        if(btnDizi[i][j] == 0){
                btn.addStyleName(ValoTheme.BUTTON_DANGER);
        }
        if(btnDizi[i][j] == 1){

            int count = 0;

            if(btnDizi[i -1][j] == 1) count++;
            if(j+1 <= btnSize && btnDizi[i -1][j+1] == 1) count++; //önceki ve sonraki buton indexleri dizi sınırlarını aşıyorsa dizide değer araması yapma.
            if(btnDizi[i -1][j -1] == 1) count++;
            if(j+1 <= btnSize && btnDizi[i][j +1] == 1) count++;
            if(btnDizi[i][j -1] == 1) count++;
            if(i+1 <= btnSize && btnDizi[i +1][j] == 1) count++;
            if(j+1 <= btnSize && i+1 <= btnSize && btnDizi[i +1][j +1] == 1) count++;
            if(i+1 <= btnSize && btnDizi[i +1][j -1] == 1) count++;

            if(count >= 3){

                btn.addStyleName(ValoTheme.BUTTON_FRIENDLY);

            }
            else{
                btnDizi[i][j] = 0;
                //     btn.setDescription(String.valueOf(0)); // buton değerlerini test etmek için
                btn.addStyleName(ValoTheme.BUTTON_DANGER);

            }

        }
    }

}