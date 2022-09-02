import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class GuiHorloge extends JFrame implements ActionListener{
    private JPanel panneau;
    private JTextField txtHorloge;
    private JButton btnStartStop;
    boolean startedClock = false;
    
    public GuiHorloge(){
        setTitle("Horloge");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 300);
        setVisible(true);
        initialserGui();
    }

    private void initialserGui(){
        FlowLayout layout = new FlowLayout();
        layout.setAlignment(FlowLayout.LEFT);
        setLayout(layout);
        panneau = new JPanel();
        panneau.setLayout(layout);
        txtHorloge = new JTextField(8);
        btnStartStop = new JButton("Démarrer");
        btnStartStop.addActionListener(this);
        panneau.add(txtHorloge);
        panneau.add(btnStartStop);

        getContentPane().add(panneau);
    }

    public boolean isStarted(){
        return startedClock;
    }

    public void actionPerformed(ActionEvent e){
        if(!startedClock){

            btnStartStop.setText("Arrêter");
            startedClock = true;
            Thread task = new Thread(){
                public void run(){
                    updateAffichage();
                }
            };
            task.start();

        }else{
            btnStartStop.setText("Démarrer");
            startedClock = false;
            txtHorloge.setText("");
        }
    }

    /*
     * Cette méthode s'exécute dans une boucle tant que l'utilisateur n'a pas cliquer sur Arrêter.
     * Elle récupère l'heure courante et l'affiche avec une cadence d'un affichage par seconde
     */
    private void updateAffichage(){
        while(isStarted()){
            Calendar calendrier=Calendar.getInstance();
            String H=calendrier.get(Calendar.HOUR_OF_DAY) + ":" 
            + calendrier.get(Calendar.MINUTE) + ":" 
            + calendrier.get(Calendar.SECOND);
            //Doit être exécuté dans l'EDT
            txtHorloge.setText(H);
            /*attente d'une seconde (la cadence de l'affichage = 1 sec)*/
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                System.exit(1);
            }
        }
    }
}

class Application{
    public static void main(String[] argv){
        GuiHorloge guiHorloge = new GuiHorloge();
    }
}