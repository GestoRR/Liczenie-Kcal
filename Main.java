import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class okno extends JFrame{
    okno(String nazwa) {
        super(nazwa);
        setResizable(true);
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER));

    }



}
public class Main {
    public static void main(String[] args) {

        int szerokosc = (850-40)/3;
        int wysokosc = 100;
        //Tworzenie okna
        Color czerwony = new Color(255,109,102);

        okno kcal = new okno("Liczenie Kcal");

        //Tworzenie panelów

        JPanel panel_bialko = new JPanel(new GridLayout(2,1));
        //panel_bialko.setBackground(Color.pink);
        panel_bialko.setPreferredSize(new Dimension(szerokosc,wysokosc));


        JPanel panel_tluszcze = new JPanel(new GridLayout(2,1));
        //panel_tluszcze.setBackground(Color.yellow);
        panel_tluszcze.setPreferredSize(new Dimension(szerokosc,wysokosc));

        JPanel panel_wegle = new JPanel(new GridLayout(2,1));
        //panel_wegle.setBackground(Color.blue);
        panel_wegle.setPreferredSize(new Dimension(szerokosc,wysokosc));

        JPanel panel_kcal = new JPanel(new GridLayout(2,1));
        //panel_kcal.setBackground(Color.gray);
        panel_kcal.setPreferredSize(new Dimension(szerokosc,wysokosc));

        JPanel panel_oblicz = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel_oblicz.setPreferredSize(new Dimension(szerokosc*2,wysokosc*2));
        //panel_oblicz.setBackground(Color.cyan);
        panel_oblicz.setBorder(BorderFactory.createEmptyBorder(40,0,0,0));


        //Tworzenie labelów
        JLabel label_bialko = new JLabel("Białko");
        label_bialko.setFont(new Font("Olek",Font.BOLD,16));
        label_bialko.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel label_tluszcze = new JLabel("Tłuszcze");
        label_tluszcze.setFont(new Font("Olek",Font.BOLD,16));
        label_tluszcze.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel label_weglowodany = new JLabel("Węglowodany");
        label_weglowodany.setFont(new Font("Olek",Font.BOLD,16));
        label_weglowodany.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel label_kcal = new JLabel("Kalorie");
        label_kcal.setFont(new Font("Olek",Font.BOLD,16));
        label_kcal.setHorizontalAlignment(SwingConstants.CENTER);


        //Tworzenie text-boxów
        JTextField bialko_text= new JTextField();
        bialko_text.setFont(new Font("Olek",Font.PLAIN,20));
        bialko_text.setHorizontalAlignment(JTextField.CENTER);

        JTextField tluszcze_text= new JTextField();
        tluszcze_text.setFont(new Font("Olek",Font.PLAIN,20));
        tluszcze_text.setHorizontalAlignment(JTextField.CENTER);

        JTextField wegle_text= new JTextField();
        wegle_text.setFont(new Font("Olek",Font.PLAIN,20));
        wegle_text.setHorizontalAlignment(JTextField.CENTER);

        JTextField kcal_text = new JTextField();
        kcal_text.setFont(new Font("Olek",Font.PLAIN,20));
        kcal_text.setHorizontalAlignment(SwingConstants.CENTER);

        //Tworzenie Buttona
        JButton przycisk_oblicz = new JButton("Oblicz");
        przycisk_oblicz.setPreferredSize(new Dimension(250,90));
        przycisk_oblicz.setFont(new Font("Olek",Font.BOLD,16));

        JButton przycisk_reset = new JButton("Reset");
        przycisk_reset.setPreferredSize(new Dimension(250,90));
        przycisk_reset.setFont(new Font("Olek",Font.BOLD,16));

        przycisk_oblicz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String bialko_string;
                Double bialko_double=0.0;
                boolean b,w,t,kcal;
                bialko_string = bialko_text.getText();

                try{
                    bialko_double = Double.valueOf(bialko_string);
                    bialko_text.setBackground(Color.white);
                    b = true;
                }
                catch(NumberFormatException f)
                {
                    bialko_text.setBackground(czerwony);
                    b = false;
                }

                String tluszcze_string;
                Double tluszcze_double=0.0;
                tluszcze_string = tluszcze_text.getText();
                try{
                    tluszcze_double = Double.valueOf(tluszcze_string);
                    tluszcze_text.setBackground(Color.white);
                    t = true;
                }
                catch(NumberFormatException f)
                {
                    tluszcze_text.setBackground(czerwony);
                    t = false;

                }

                String weglowodany_string;
                Double weglowodany_double=0.0;
                weglowodany_string = wegle_text.getText();
                try{
                    weglowodany_double = Double.valueOf(weglowodany_string);
                    wegle_text.setBackground(Color.white);
                    w = true;
                }
                catch(NumberFormatException f)
                {
                    wegle_text.setBackground(Color.getHSBColor(255,109,102));
                    w = false;
                }

                String kcal_string;
                Double kcal_double=0.0;
                kcal_string = kcal_text.getText();
                try{kcal_double = Double.valueOf(kcal_string);
                    kcal_text.setBackground(Color.white);
                    kcal = true;}
                catch(NumberFormatException f){
                    kcal_text.setBackground(Color.getHSBColor(255,109,102));
                    kcal = false;
                }

                if ((b == true & w==true & t==true & kcal==false)) {
                    kcal_text.setText(String.format("%.2f",(bialko_double*4 + weglowodany_double *4 + tluszcze_double*9)));
                    kcal_text.setBackground(Color.green);
                }
                else if (b == false & w==true & t==true & kcal==true){
                    bialko_text.setText(String.format("%.2f",(kcal_double-4*weglowodany_double-9*tluszcze_double)/4));
                    bialko_text.setBackground(Color.green);
                }
                else if (b == true & w==false & t==true & kcal==true){
                    wegle_text.setText(String.format("%.2f",(kcal_double-4*bialko_double-9*tluszcze_double)/4));
                    wegle_text.setBackground(Color.green);
                }
                else if (b == true & w==true & t==false & kcal==true)
                {

                    tluszcze_text.setText(String.format("%.2f",((kcal_double-4*bialko_double-4*weglowodany_double)/9)));
                    tluszcze_text.setBackground(Color.green);
                }
                else if ((b == true & w==true & t==true & kcal==true))
                {
                    bialko_text.setBackground(czerwony);
                    wegle_text.setBackground(czerwony);
                    tluszcze_text.setBackground(czerwony);
                    kcal_text.setBackground(czerwony);
                }

            }
        });

        przycisk_reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kcal_text.setText(null);
                kcal_text.setBackground(Color.white);
                bialko_text.setText(null);
                bialko_text.setBackground(Color.white);
                wegle_text.setText(null);
                wegle_text.setBackground(Color.white);
                tluszcze_text.setText(null);
                tluszcze_text.setBackground(Color.white);

            }
        });


        kcal.add(panel_bialko);
        kcal.add(panel_tluszcze);
        kcal.add(panel_wegle);
        kcal.add(panel_kcal);
        kcal.add(panel_oblicz);
        panel_bialko.add(label_bialko);
        panel_bialko.add(bialko_text);
        panel_tluszcze.add(label_tluszcze);
        panel_tluszcze.add(tluszcze_text);
        panel_wegle.add(label_weglowodany);
        panel_wegle.add(wegle_text);
        panel_kcal.add(label_kcal);
        panel_kcal.add(kcal_text);
        panel_oblicz.add(przycisk_reset);
        panel_oblicz.add(przycisk_oblicz);
        kcal.setVisible(true);
    }
}