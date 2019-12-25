package egitim.uniyaz;

import com.google.gwt.layout.client.Layout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class Kata extends VerticalLayout {
    public Kata() {
        setMargin(true);
        setSpacing(true);
        fillLayout();
//        Tahta tahta=new Tahta(4);
//        addComponent(tahta);
    }

    private void fillLayout() {

        TextField butonSayisi = new TextField();
        addComponent(butonSayisi);

        Button girisButon = new Button();
        girisButon.setCaption("Giriş");
        girisButon.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                createTahta(butonSayisi);
                girisButon.setEnabled(false);
            }
        });
        addComponent(girisButon);
    }

    private void createTahta(TextField butonSayisi) {
        int sayi= Integer.parseInt(butonSayisi.getValue());
        butonSayisi.setEnabled(false);
        Tahta tahta=new Tahta(sayi);
        addComponent(tahta);
    }
}
