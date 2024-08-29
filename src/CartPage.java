import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DecimalFormat;

public class CartPage extends JFrame {

    String[] foodnameCart;
    double[] foodpriceCart;
    int[] foodqtyCart;
    double[] Total;
    int sizeCart, y1, y2, y3;
    double subPrice = 0, taxPrice = 0, servicePrice = 0, totPrice = 0;

    JLabel lab, labSubtotal, labTotal, labTax, labServChar, labPromo, subTot, tot, tax, servChar;
    JLabel[] foodList, priceList, qtyList;
    JButton back, confirm;
    JTextField promoCode;

    DecimalFormat df = new DecimalFormat("0.00");
    CartPage(){
        sizeCart = 12;
        foodnameCart = new String[sizeCart];
        foodpriceCart = new double[sizeCart];
        foodqtyCart = new int[sizeCart];
        Total = new double[sizeCart];

        //----frame----
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        setSize(500, 700);
        //setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void setJPanelandComponent(){
        JPanel jpanel = new JPanel();
        jpanel.setPreferredSize(new Dimension(500, 900));
        jpanel.setBackground(Color.pink);
        jpanel.setLayout(null);

//----scrollPane----
        JScrollPane js = new JScrollPane(jpanel);
        js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        js.setPreferredSize(new Dimension(450, 650));
        add(js);

//----label----
        lab = new JLabel("MY ORDER");
        lab.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        lab.setBounds(140, 10, 300, 30);
        jpanel.add(lab);

//------------Food Name List------------
        foodList = new JLabel[sizeCart];
        y1 = 100;
        for(int i=0; i<sizeCart; i++) {
            if(!(foodnameCart[i] == null)){
                foodList[i] = new JLabel(foodnameCart[i]);
                foodList[i].setFont(new Font("Comic Sans MS", Font.BOLD, 12));
                foodList[i].setBounds(20, y1, 140, 40);
                jpanel.add(foodList[i]);
                System.out.println("test at jlabel: "+foodnameCart[i]);
                y1+=50;
            }
        }
//------------Food Price List------------
        priceList = new JLabel[sizeCart];
        y2 = 100;
        for(int i=0; i<sizeCart; i++) {
            if(Total[i]!=0){
                priceList[i] = new JLabel("RM " + df.format(Total[i]));
                priceList[i].setFont(new Font("Comic Sans MS", Font.BOLD, 12));
                priceList[i].setBounds(300, y2, 140, 40);
                y2+=50;
                jpanel.add(priceList[i]);
            }
        }
//------------Food Quantity List------------
        qtyList = new JLabel[sizeCart];
        y3 = 100;
        for(int i=0; i<sizeCart; i++) {
            if(foodqtyCart[i]!=0){
                qtyList[i] = new JLabel("" + foodqtyCart[i]);
                qtyList[i].setFont(new Font("Comic Sans MS", Font.BOLD, 12));
                qtyList[i].setBounds(240, y3, 50, 40);
                y3+=50;
                jpanel.add(qtyList[i]);
            }
        }

//------------Subtotal------------
        labSubtotal = new JLabel("SUBTOTAL");
        labSubtotal.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        labSubtotal.setBounds(20, 600, 90, 30);
        jpanel.add(labSubtotal);

        subTot = new JLabel("RM " + df.format(subPrice));
        subTot.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        subTot.setBounds(300, 595, 140, 40);
        jpanel.add(subTot);

//------------Service Charge------------
        labServChar = new JLabel("SERVICE CHARGE (5%)");
        labServChar.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        labServChar.setBounds(20, 630, 200, 30);
        jpanel.add(labServChar);

        servicePrice = 0.05*subPrice;
        servChar = new JLabel("RM " + df.format(servicePrice));
        servChar.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        servChar.setBounds(300, 625, 140, 40);
        jpanel.add(servChar);

//------------Tax------------
        labTax = new JLabel("TAX (6%)");
        labTax.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        labTax.setBounds(20, 660, 100, 30);
        jpanel.add(labTax);

        taxPrice = 0.06*subPrice;
        tax = new JLabel("RM " + df.format(taxPrice));
        tax.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        tax.setBounds(300, 655, 140, 40);
        jpanel.add(tax);

//------------Promo code------------
        labPromo = new JLabel("PROMO CODE");
        labPromo.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        labPromo.setBounds(20, 710, 150, 30);
        jpanel.add(labPromo);

//------------Total------------
        labTotal = new JLabel("TOTAL");
        labTotal.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        labTotal.setBounds(20, 780, 60, 30);
        jpanel.add(labTotal);

        totPrice = subPrice+servicePrice+taxPrice;
        tot = new JLabel("RM " + df.format(totPrice));
        tot.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        tot.setBounds(300, 775, 140, 40);
        jpanel.add(tot);

//----textField promo----
        promoCode = new JTextField();
        promoCode.setText("Enter promo code");
        promoCode.setBounds(300, 710, 140, 40);
        promoCode.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(promoCode.getText().trim().equals("Enter promo code")){
                    promoCode.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(promoCode.getText().trim().equals("")){
                    promoCode.setText("Enter promo code");
                }
            }
        });
        jpanel.add(promoCode);

//----back button----
        back = new JButton();
        back.setBounds(0, 0, 20, 20);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuPage();
            }
        });
        jpanel.add(back);

//----confirm button----
        confirm = new JButton("CONFIRM ORDER");
        confirm.setBounds(0, 820, 440, 70);
        /*confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new lastPage();
            }
        });*/
        jpanel.add(confirm);

    }

    public void cartList(int[] qtyCart, double[] priceCart, String[] nameCart){

        //------------cake------------
        for(int i=0; i<sizeCart; i++){
            if(qtyCart[i] != 0){
                foodnameCart[i] = nameCart[i];
                foodpriceCart[i] = priceCart[i];
                foodqtyCart[i] = qtyCart[i];
                Total[i] = foodqtyCart[i]*foodpriceCart[i];
                System.out.println("test at loop: " + foodnameCart[i]);
                subPrice += Total[i];
            }
        }
        setJPanelandComponent();
        //------------hot meals------------
        /*for(int i=0; i<sizeCart; i++){
            if(!"".equals(cake.foodCart[i])){
                foodnameCart[i] = hotMeals.foodCart[i];
                foodpriceCart[i] = hotMeals.priceCart[i];
                foodqtyCart[i] = hotMeals.qntty[i];
                Total[i] = foodqtyCart[i]*foodpriceCart[i];
            }
        }*/
        //------------beverage------------
        /*for(int i=0; i<sizeCart; i++){
            if(!"".equals(cake.foodCart[i])){
                foodnameCart[i] = beverage.foodCart[i];
                foodpriceCart[i] = beverage.priceCart[i];
                foodqtyCart[i] = beverage.qntty[i];
                Total[i] = foodqtyCart[i]*foodpriceCart[i];
            }
        }*/
    }

    public static void main(String[] args){
        new CartPage();
    }
}