import javax.swing.*;
import javax.swing.plaf.metal.MetalCheckBoxIcon;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DecimalFormat;

public class MenuPage extends JFrame implements ActionListener{

    JButton back, back1, cartButton, b1, b2, b3, pic1, pic2, pic3, pic4,
            pic11, pic12, pic13, pic14, pic21, pic22, pic23, pic24;
    JLabel label, title, name1, name2, name3, name4, desc1, desc2, desc3, desc4,
            name11, name12, name13, name14, desc11, desc12, desc13, desc14,
            name21, name22, name23, name24, desc21, desc22, desc23, desc24,
            txtHot1, txtHot2, txtHot3, txtHot4, txtCold1, txtCold2, txtCold3, txtCold4;
    JCheckBox cb1, cb2, cb3, cb4, cb11, cb12, cb13, cb14, cb21, cb22, cb23, cb24;
    JTextField qty1, qty2, qty3, qty4, qty11, qty12, qty13, qty14,
            qtyHot1, qtyHot2, qtyHot3, qtyHot4, qtyCold1, qtyCold2, qtyCold3, qtyCold4;
    double price1, price2, price3, price4, price11, price12, price13, price14,
            price21, price22, price23, price24;
    ImageIcon icon1, icon2, icon3, icon4, icon11, icon12, icon13, icon14, icon21, icon22, icon23, icon24;
    public int size = 12;
    int[] qntty = new int[size];
    String[] foodCart = new String[size];
    double[] priceCart = new double[size];
    DecimalFormat df = new DecimalFormat("0.00");
    public MenuPage() {
        setTitle("Triple H Bakery");
        //setLayout(new FlowLayout());
        setJPanelMenuPage();
        setSize(500, 700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void setJPanelMenuPage(){
        //----panel----
        JPanel p = new JPanel();
        p.setPreferredSize(new Dimension(500, 700));
        p.setVisible(true);
        p.setLayout(null);
        p.setBackground(new Color(248, 218, 119, 232));

        //----button back----
        Icon home = UIManager.getIcon("FileChooser.homeFolderIcon");
        JButton back = new JButton(home);
        back.setBounds(0, 0, 20, 20);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //dispose();
                setVisible(false);
                new WelcomePage();
            }
        });
        p.add(back);

        //----label----
        label = new JLabel("TRIPLE H BAKERY");
        label.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        label.setBounds(130, 40, 300, 30);

        //----button1----
        ImageIcon cake = new ImageIcon("cake.jpg");
        Image image = cake.getImage();
        Image newimg = image.getScaledInstance(390,100, Image.SCALE_SMOOTH);
        ImageIcon newimgIcon = new ImageIcon(newimg);
        b1 = new JButton("CAKE",newimgIcon);
        b1.setVerticalTextPosition(JButton.CENTER);
        b1.setHorizontalTextPosition(JButton.CENTER);
        b1.setBounds(50, 160, 390, 100);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //dispose();
                p.setVisible(false);
                setJPanelCakePage();
            }
        });

        //----button2----
        ImageIcon meal = new ImageIcon("hotmeal1.jpg");
        Image image2 = meal.getImage();
        Image newimg2 = image2.getScaledInstance(390,100, Image.SCALE_SMOOTH);
        ImageIcon newimgIcon2 = new ImageIcon(newimg2);
        b2 = new JButton("HOT MEALS",newimgIcon2);
        b2.setVerticalTextPosition(JButton.CENTER);
        b2.setHorizontalTextPosition(JButton.CENTER);
        b2.setBounds(50, 280, 390, 100);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //dispose();
                //new HotMealsPage();
                p.setVisible(false);
                setJPanelHotMealsPage();
            }
        });

        //----button3----
        ImageIcon beverage = new ImageIcon("beverage.jpg");
        Image image3 = beverage.getImage();
        Image newimg3 = image3.getScaledInstance(390,100, Image.SCALE_SMOOTH);
        ImageIcon newimgIcon3 = new ImageIcon(newimg3);
        b3 = new JButton("BEVERAGE",newimgIcon3);
        b3.setVerticalTextPosition(JButton.CENTER);
        b3.setHorizontalTextPosition(JButton.CENTER);
        b3.setBounds(50, 400, 390, 100);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //dispose();
                p.setVisible(false);
                setJPanelBeveragePage();
            }
        });

        p.add(label); p.add(b1); p.add(b2); p.add(b3);
        add(p);
    }

    private void setJPanelCakePage(){
        //----panel----
        JPanel jp = new JPanel();
        jp.setVisible(true);
        jp.setPreferredSize(new Dimension(500, 900));
        jp.setBackground(Color.ORANGE);

        //----back button----
        backButton(jp);

        //----cart button----
        cartButton = new JButton("Cart");
        cartButton.setBackground(new Color(0xF1EA6E));
        cartButton.setBounds(360, 0, 125, 50);
        cartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CartPage cart = new CartPage();
                //cart.cartList(qntty, priceCart, foodCart);
                cart.cartList(qntty, priceCart, foodCart);
                cart.setVisible(true);
                setVisible(false);
            }
        });


        //----images----
        icon1 = new ImageIcon("src/redvelvet.jpg");
        Image img1 = icon1.getImage();
        Image newimg1 = img1.getScaledInstance( 150, 100,  Image.SCALE_AREA_AVERAGING);
        icon1 = new ImageIcon(newimg1); //RED VELVET

        icon2 = new ImageIcon("src/oreocheese.jpg");
        Image img2 = icon2.getImage();
        Image newimg2 = img2.getScaledInstance( 150, 100,  Image.SCALE_AREA_AVERAGING);
        icon2 = new ImageIcon(newimg2); //OREO

        icon3 = new ImageIcon("src/blueberrycheese.jpg");
        Image img3 = icon3.getImage();
        Image newimg3 = img3.getScaledInstance( 150, 100,  Image.SCALE_AREA_AVERAGING);
        icon3 = new ImageIcon(newimg3); //BLUEBERRY

        icon4 = new ImageIcon("src/chocfudge.jpg");
        Image img4  = icon4.getImage();
        Image newimg4 = img4.getScaledInstance( 150, 100,  Image.SCALE_AREA_AVERAGING);
        icon4 = new ImageIcon(newimg4);

        //----menus----
        title = new JLabel("Cakes");
        title.setBounds(170, 10, 300, 25);
        title.setFont(new Font("Brush Script MT", Font.BOLD, 30));

        pic1 = new JButton("Red Velvet Cake", icon1);
        pic1.setBounds(10, 50, 125, 100);
        price1 = 10.00;
        desc1 = new JLabel("<html><p>Creamy and soft cheese layered"
                + "<p>between fluffy red velvet sponge"
                + "<p>with cherries on top.<br>"
                + "<p>RM" + df.format(price1) + " per slice");
        desc1.setFont(new Font("Serif", Font.BOLD, 14));
        desc1.setBounds(150, 70, 200, 75);
        name1 = new JLabel("Red Velvet Cake");
        name1.setFont(new Font("Lucida Handwriting", Font.BOLD, 13));
        name1.setBounds(150, 50, 200, 25);
        cb1 = new JCheckBox();
        cb1.addActionListener(this);
        cb1.setIcon(new MetalCheckBoxIcon() {
            @Override
            protected int getControlSize() {
                return 30;
            }
        });
        cb1.setBounds(375, 75, 35, 30);

        qty1 = new JTextField();
        qty1.setText("Enter quantity");
        qty1.setBounds(150, 150, 100, 25);
        //qty.setEnabled(false);
        qty1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(qty1.getText().trim().equals("Enter quantity")){
                    qty1.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(qty1.getText().trim().equals("")){
                    qty1.setText("Enter quantity");
                }
            }
        });

        pic2 = new JButton("Oreo Cheesecake", icon2);
        pic2.setBounds(10, 200, 125, 100);
        price2 = 99.00;
        desc2 = new JLabel("<html><p>Fresh and creamy cheese"
                + "<p>topped with premium chocolate"
                + "<p>and Oreo biscuits.<br>"
                + "<p>RM" + df.format(price2));
        desc2.setFont(new Font("Serif", Font.BOLD, 14));
        desc2.setBounds(150, 220, 200, 75);
        name2 = new JLabel("Oreo Cheesecake");
        name2.setFont(new Font("Lucida Handwriting", Font.BOLD, 13));
        name2.setBounds(150, 200, 200, 25);
        cb2 = new JCheckBox();
        cb2.addActionListener( this);
        cb2.setIcon(new MetalCheckBoxIcon() {
            @Override
            protected int getControlSize() {
                return 30;
            }
        });
        cb2.setBounds(375, 225, 35, 30);

        qty2 = new JTextField();
        qty2.setText("Enter quantity");
        qty2.setBounds(150, 300, 100, 25);
        //qty2.setEnabled(false);

        qty2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(qty2.getText().trim().equals("Enter quantity")){
                    qty2.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(qty2.getText().trim().equals("")){
                    qty2.setText("Enter quantity");
                }
            }
        });

        pic3 = new JButton("Blueberry Cheesecake", icon3);
        pic3.setBounds(10, 350, 125, 100);
        price3 = 89.00;
        desc3 = new JLabel("<html><p>Smooth baked cheese topped"
                + "<p>with mix of blueberries and"
                + "<p>blackberries fresh from Jasin.<br>"
                + "<p>RM" + df.format(price3));
        desc3.setFont(new Font("Serif", Font.BOLD, 14));
        desc3.setBounds(150, 370, 200, 75);
        name3 = new JLabel("Blueberry Cheesecake");
        name3.setFont(new Font("Lucida Handwriting", Font.BOLD, 13));
        name3.setBounds(150, 350, 200, 25);
        cb3 = new JCheckBox();
        cb3.addActionListener( this);
        cb3.setIcon(new MetalCheckBoxIcon() {
            @Override
            protected int getControlSize() {
                return 30;
            }
        });
        cb3.setBounds(375, 375, 35, 30);

        qty3 = new JTextField();
        qty3.setText("Enter quantity");
        qty3.setBounds(150, 450, 100, 25);
        qty3.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(qty3.getText().trim().equals("Enter quantity")){
                    qty3.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(qty3.getText().trim().equals("")){
                    qty3.setText("Enter quantity");
                }
            }
        });

        pic4 = new JButton("Chocolate Fudge Cake", icon4);
        pic4.setBounds(10, 500, 125, 100);
        price4 = 75.00;
        desc4 = new JLabel("<html><p>Premium belgian chocolate"
                + "<p>on top of fluffy mouthwatering"
                + "<p>chocolate sponge <br>"
                + "<p>RM" + df.format(price4));
        desc4.setFont(new Font("Serif", Font.BOLD, 14));
        desc4.setBounds(150, 520, 200, 75);
        name4 = new JLabel("Chocolate Fudge Cake");
        name4.setFont(new Font("Lucida Handwriting", Font.BOLD, 13));
        name4.setBounds(150, 500, 200, 25);
        cb4 = new JCheckBox();
        cb4.addActionListener( this);
        cb4.setIcon(new MetalCheckBoxIcon() {
            @Override
            protected int getControlSize() {
                return 30;
            }
        });
        cb4.setBounds(375, 525, 35, 30);

        qty4 = new JTextField();
        qty4.setText("Enter quantity");
        qty4.setBounds(150, 600, 100, 25);
        //qty4.setEnabled(false);

        qty4.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(qty4.getText().trim().equals("Enter quantity")){
                    qty4.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(qty4.getText().trim().equals("")){
                    qty4.setText("Enter quantity");
                }
            }
        });


        jp.add(cartButton); jp.add(title);

        jp.add(pic1); jp.add(pic2); jp.add(pic3); jp.add(pic4);
        jp.add(name1); jp.add(name2); jp.add(name3); jp.add(name4);
        jp.add(desc1); jp.add(desc2); jp.add(desc3); jp.add(desc4);
        jp.add(cb1); jp.add(cb2); jp.add(cb3); jp.add(cb4);
        jp.add(qty1); jp.add(qty2); jp.add(qty3); jp.add(qty4);
        add(jp);
        jp.setLayout(null);

        //----scrollPane----
        //scrollPane(jp);
        /*JScrollPane js = new JScrollPane(jp);
        js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        js.setPreferredSize(new Dimension(450, 650));
        add(js);*/
    }

    private void setJPanelHotMealsPage(){
        //----panel----
        JPanel jp = new JPanel();
        jp.setPreferredSize(new Dimension(500, 900));
        jp.setBackground(Color.ORANGE);

        //----back button----
        backButton(jp);

        //----cart button----
        cartButton = new JButton("Cart");
        cartButton.setBackground(new Color(0xF1EA6E));
        cartButton.setBounds(360, 0, 125, 50);
        cartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CartPage cart = new CartPage();
                cart.cartList(qntty, priceCart, foodCart);
                cart.setVisible(true);
                //dispose();
                setVisible(false);
            }
        });


        //----images----
        icon11 = new ImageIcon("src/aglioolio.jpg");
        Image img11 = icon11.getImage();
        Image newimg11 = img11.getScaledInstance( 150, 100,  Image.SCALE_AREA_AVERAGING);
        icon11 = new ImageIcon(newimg11); //RED VELVET

        icon12 = new ImageIcon("src/buttermilkRice.jpg");
        Image img12 = icon12.getImage();
        Image newimg12 = img12.getScaledInstance( 150, 100,  Image.SCALE_AREA_AVERAGING);
        icon12 = new ImageIcon(newimg12); //OREO

        icon13 = new ImageIcon("src/roastedduck.jpg");
        Image img13 = icon13.getImage();
        Image newimg13 = img13.getScaledInstance( 150, 100,  Image.SCALE_AREA_AVERAGING);
        icon13 = new ImageIcon(newimg13); //BLUEBERRY

        icon14 = new ImageIcon("src/macandcheese.jpg");
        Image img14  = icon14.getImage();
        Image newimg14 = img14.getScaledInstance( 150, 100,  Image.SCALE_AREA_AVERAGING);
        icon14 = new ImageIcon(newimg14); //TAKTAU

        //----menus----
        title = new JLabel("Hot Meals");
        title.setBounds(150, 10, 300, 25);
        title.setFont(new Font("Brush Script MT", Font.BOLD, 30));

        pic11 = new JButton("Aglio Olio", icon11);
        pic11.setBounds(10, 50, 125, 100);
        price11 = 18.00;
        desc11 = new JLabel("<html><p>Italian pasta dish"
                + "<p>comes with fresh seafood.<br>"
                + "<p>RM" + df.format(price11));
        desc11.setFont(new Font("Serif", Font.BOLD, 14));
        desc11.setBounds(150, 70, 200, 75);
        name11 = new JLabel("Aglio Olio");
        name11.setFont(new Font("Lucida Handwriting", Font.BOLD, 13));
        name11.setBounds(150, 50, 200, 25);
        cb11 = new JCheckBox();
        cb11.addActionListener(this);
        cb11.setIcon(new MetalCheckBoxIcon() {
            @Override
            protected int getControlSize() {
                return 30;
            }
        });
        cb11.setBounds(375, 75, 35, 30);

        qty11 = new JTextField();
        qty11.setText("Enter quantity");
        qty11.setBounds(150, 150, 100, 25);
        //qty11.setEnabled(false);
        qty11.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(qty11.getText().trim().equals("Enter quantity")){
                    qty11.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(qty11.getText().trim().equals("")){
                    qty11.setText("Enter quantity");
                }
            }
        });

        pic12 = new JButton("Buttermilk Chicken Rice", icon12);
        pic12.setBounds(10, 200, 125, 100);
        price12 = 15.00;
        desc12 = new JLabel("<html><p>The chicken is fried and"
                + "<p>served in a flavourful gravy"
                + "<p>made of with milk and spices<br>"
                + "<p>RM" + df.format(price12));
        desc12.setFont(new Font("Serif", Font.BOLD, 14));
        desc12.setBounds(150, 220, 200, 75);
        name12 = new JLabel("Buttermilk Chicken Rice");
        name12.setFont(new Font("Lucida Handwriting", Font.BOLD, 13));
        name12.setBounds(150, 200, 200, 25);
        cb12 = new JCheckBox();
        cb12.addActionListener( this);
        cb12.setIcon(new MetalCheckBoxIcon() {
            @Override
            protected int getControlSize() {
                return 30;
            }
        });
        cb12.setBounds(375, 225, 35, 30);

        qty12 = new JTextField();
        qty12.setText("Enter quantity");
        qty12.setBounds(150, 300, 100, 25);
        //qty12.setEnabled(false);

        qty12.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(qty12.getText().trim().equals("Enter quantity")){
                    qty12.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(qty12.getText().trim().equals("")){
                    qty12.setText("Enter quantity");
                }
            }
        });

        pic13 = new JButton("Roasted Duck", icon13);
        pic13.setBounds(10, 350, 125, 100);
        price13 = 49.00;
        desc13 = new JLabel("<html><p>Tender and juicy meat, crispy"
                + "<p>skin and glazed with the"
                + "<p>honey balsamic glaze.<br>"
                + "<p>RM" + df.format(price13));
        desc13.setFont(new Font("Serif", Font.BOLD, 14));
        desc13.setBounds(150, 370, 200, 75);
        name13 = new JLabel("Roasted Duck");
        name13.setFont(new Font("Lucida Handwriting", Font.BOLD, 13));
        name13.setBounds(150, 350, 200, 25);
        cb13 = new JCheckBox();
        cb13.addActionListener( this);
        cb13.setIcon(new MetalCheckBoxIcon() {
            @Override
            protected int getControlSize() {
                return 30;
            }
        });
        cb13.setBounds(375, 375, 35, 30);

        qty13 = new JTextField();
        qty13.setText("Enter quantity");
        qty13.setBounds(150, 450, 100, 25);

        qty13.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(qty13.getText().trim().equals("Enter quantity")){
                    qty13.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(qty13.getText().trim().equals("")){
                    qty13.setText("Enter quantity");
                }
            }
        });

        pic14 = new JButton("Mac & Cheese", icon14);
        pic14.setBounds(10, 500, 125, 100);
        price14 = 13.00;
        desc14 = new JLabel("<html><p>Simple combination of"
                + "<p>macaroni and melted cheese"
                + "<p>with prawns.<br>"
                + "<p>RM" + df.format(price14));
        desc14.setFont(new Font("Serif", Font.BOLD, 14));
        desc14.setBounds(150, 520, 200, 75);
        name14 = new JLabel("Mac & Cheese");
        name14.setFont(new Font("Lucida Handwriting", Font.BOLD, 13));
        name14.setBounds(150, 500, 200, 25);
        cb14 = new JCheckBox();
        cb14.addActionListener( this);
        cb14.setIcon(new MetalCheckBoxIcon() {
            @Override
            protected int getControlSize() {
                return 30;
            }
        });
        cb14.setBounds(375, 525, 35, 30);

        qty14 = new JTextField();
        qty14.setText("Enter quantity");
        qty14.setBounds(150, 600, 100, 25);
//qty14.setEnabled(false);

        qty14.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(qty14.getText().trim().equals("Enter quantity")){
                    qty14.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(qty14.getText().trim().equals("")){
                    qty14.setText("Enter quantity");
                }
            }
        });

        jp.add(cartButton);
        jp.add(title);

        jp.add(pic11); jp.add(pic12); jp.add(pic13); jp.add(pic14);
        jp.add(name11); jp.add(name12); jp.add(name13); jp.add(name14);
        jp.add(desc11); jp.add(desc12); jp.add(desc13); jp.add(desc14);
        jp.add(cb11); jp.add(cb12); jp.add(cb13); jp.add(cb14);
        jp.add(qty11); jp.add(qty12); jp.add(qty13); jp.add(qty14);
        add(jp);
        jp.setLayout(null);

        //----scrollPane----
        //scrollPane(jp);
        /*JScrollPane js = new JScrollPane(jp);
        js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        js.setPreferredSize(new Dimension(450, 650));
        add(js);*/
    }

    private void setJPanelBeveragePage(){
        //----panel----
        JPanel jp = new JPanel();
        jp.setPreferredSize(new Dimension(500,800));
        jp.setBackground(Color.ORANGE);

        //----back button----
        backButton(jp);

        //----cart button----
        cartButton = new JButton("Cart");
        cartButton.setBounds(360, 0, 125, 50);
        cartButton.setBackground(new Color(0xF1EA6E));
        cartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CartPage cart = new CartPage();
                //cart.cartList(qntty, priceCart, foodCart);
                cart.cartList(qntty, priceCart, foodCart);
                cart.setVisible(true);
                //dispose();
                setVisible(false);
            }
        });
//----------------image-------------------------------
        icon21 = new ImageIcon("src/strawberries.jpg");
        Image img = icon21.getImage();
        Image newimg = img.getScaledInstance( 150, 100,  Image.SCALE_AREA_AVERAGING);
        icon21 = new ImageIcon(newimg);

        icon22 = new ImageIcon("src/oreo.jpg");
        Image img22 = icon22.getImage();
        Image newimg22 = img22.getScaledInstance( 150, 100,  Image.SCALE_AREA_AVERAGING);
        icon22 = new ImageIcon(newimg22);

        icon23 = new ImageIcon("src/kopicino.jpg");
        Image img23 = icon23.getImage();
        Image newimg23 = img23.getScaledInstance( 150, 100,  Image.SCALE_AREA_AVERAGING);
        icon23 = new ImageIcon(newimg23);

        icon24 = new ImageIcon("src/caramellatte.jpg");
        Image img24 = icon24.getImage();
        Image newimg24 = img24.getScaledInstance( 150, 100,  Image.SCALE_AREA_AVERAGING);
        icon24 = new ImageIcon(newimg24);

//----------------menu-------------------------------
        title = new JLabel("Beverages");
        title.setBounds(150, 10, 300, 25);
        title.setFont(new Font("Brush Script MT", Font.BOLD, 30));

        pic21= new JButton("Strawberries Smoothies", icon21);
        pic21.setBounds(10, 50, 125, 100);
        price21 = 14.50;
        desc21 = new JLabel("<html><p>Made of fresh-from-farm"
                + "<p>strawberries and bits of banana"
                + "<p>that excites your taste buds.<br>"
                + "<p>RM" + df.format(price21));
        desc21.setFont(new Font("Serif", Font.BOLD, 14));
        desc21.setBounds(150, 75, 200, 75);
        name21 = new JLabel("Strawberries Smoothies");
        name21.setFont(new Font("Lucida Handwriting", Font.BOLD, 13));
        name21.setBounds(150, 50, 200, 25);
        cb21 = new JCheckBox();
        cb21.addActionListener( this);
        cb21.setIcon(new MetalCheckBoxIcon() {
            @Override
            protected int getControlSize() {
                return 30;
            }
        });
        cb21.setBounds(375, 75, 35, 30);
        qtyHot1 = new JTextField("0");
        qtyHot1.setEnabled(false);
        qtyHot1.setBounds(185, 150, 25, 25);
        qtyHot1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(qtyHot1.getText().trim().equals("0")){
                    qtyHot1.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(qtyHot1.getText().trim().equals("")){
                    qtyHot1.setText("0");
                }
            }
        });
        txtHot1 = new JLabel("HOT: ");
        txtHot1.setBounds(150, 150, 50,25);
        qtyCold1 = new JTextField("0");
        qtyCold1.setBounds(260, 150, 25, 25);
        qtyCold1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(qtyCold1.getText().trim().equals("0")){
                    qtyCold1.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(qtyCold1.getText().trim().equals("")){
                    qtyCold1.setText("0");
                }
            }
        });
        txtCold1 = new JLabel("COLD: ");
        txtCold1.setBounds(215, 150, 50, 25);

        pic22= new JButton("Oreo Milkshake", icon22);
        pic22.setBounds(10, 200, 125, 100);
        price22 = 13.50;
        desc22 = new JLabel("<html><p>Classic Oreo milkshake"
                + "<p>with chilling taste of vanilla"
                + "<p>and crushed Oreos on top.<br>"
                + "<p>RM" + df.format(price22));
        desc22.setFont(new Font("Serif", Font.BOLD, 14));
        desc22.setBounds(150, 225, 200, 75);
        name22 = new JLabel("Oreo Milkshake");
        name22.setFont(new Font("Lucida Handwriting", Font.BOLD, 12));
        name22.setBounds(150, 200, 200, 25);
        cb22 = new JCheckBox();
        cb22.addActionListener( this);
        cb22.setIcon(new MetalCheckBoxIcon() {
            @Override
            protected int getControlSize() {
                return 30;
            }
        });
        cb22.setBounds(375, 225, 35, 30);
        qtyHot2 = new JTextField("0");
        qtyHot2.setEnabled(false);
        qtyHot2.setBounds(185, 300, 25, 25);
        qtyHot2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(qtyHot2.getText().trim().equals("0")){
                    qtyHot2.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(qtyHot2.getText().trim().equals("")){
                    qtyHot2.setText("0");
                }
            }
        });
        txtHot2 = new JLabel("HOT: ");
        txtHot2.setBounds(150, 300, 50,25);
        qtyCold2 = new JTextField("0");
        qtyCold2.setBounds(260, 300, 25, 25);
        qtyCold2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(qtyCold2.getText().trim().equals("0")){
                    qtyCold2.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(qtyCold2.getText().trim().equals("")){
                    qtyCold2.setText("0");
                }
            }
        });
        txtCold2 = new JLabel("COLD: ");
        txtCold2.setBounds(215, 300, 50, 25);

        pic23= new JButton("Americano", icon23);
        pic23.setBounds(10, 350, 125, 100);
        price23 = 8.00;
        desc23 = new JLabel("<html><p>Brewed with world's"
                + "<p>most quality coffee beans."
                + "<p>Perfect drink to start your day.<br>"
                + "<p>RM" + df.format(price23));
        desc23.setFont(new Font("Serif", Font.BOLD, 14));
        desc23.setBounds(150, 375, 200, 75);
        name23 = new JLabel("Americano");
        name23.setFont(new Font("Lucida Handwriting", Font.BOLD, 12));
        name23.setBounds(150, 350, 200, 25);
        cb23 = new JCheckBox();
        cb23.addActionListener( this);
        cb23.setIcon(new MetalCheckBoxIcon() {
            @Override
            protected int getControlSize() {
                return 30;
            }
        });
        cb23.setBounds(375, 375, 35, 30);
        qtyHot3 = new JTextField("0");
        qtyHot3.setBounds(185, 450, 25, 25);
        qtyHot3.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(qtyHot3.getText().trim().equals("0")){
                    qtyHot3.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(qtyHot3.getText().trim().equals("")){
                    qtyHot3.setText("0");
                }
            }
        });
        txtHot3 = new JLabel("HOT: ");
        txtHot3.setBounds(150, 450, 50,25);
        qtyCold3 = new JTextField("0");
        qtyCold3.setBounds(260, 450, 25, 25);
        qtyCold3.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(qtyCold3.getText().trim().equals("0")){
                    qtyCold3.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(qtyCold3.getText().trim().equals("")){
                    qtyCold3.setText("0");
                }
            }
        });
        txtCold3 = new JLabel("COLD: ");
        txtCold3.setBounds(215, 450, 50, 25);

        pic24= new JButton("Caramel Latte", icon24);
        pic24.setBounds(10, 500, 125, 100);
        price24 = 12.00;
        desc24 = new JLabel("<html><p>Fresh latte's bitter + subtle"
                + "<p>caramel's sweetness. A suitable"
                + "<p>drink for a relaxing day.<br>"
                + "<p>RM" + df.format(price24));
        desc24.setFont(new Font("Serif", Font.BOLD, 14));
        desc24.setBounds(150, 525, 200, 75);
        name24 = new JLabel("Caramel Latte");
        name24.setFont(new Font("Lucida Handwriting", Font.BOLD, 12));
        name24.setBounds(150, 500, 200, 25);
        cb24 = new JCheckBox();
        cb24.addActionListener( this);
        cb24.setIcon(new MetalCheckBoxIcon() {
            @Override
            protected int getControlSize() {
                return 30;
            }
        });
        cb24.setBounds(375, 525, 35, 30);
        qtyHot4 = new JTextField("0");
        qtyHot4.setBounds(185, 600, 25, 25);
        qtyHot4.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(qtyHot4.getText().trim().equals("0")){
                    qtyHot4.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(qtyHot4.getText().trim().equals("")){
                    qtyHot4.setText("0");
                }
            }
        });
        txtHot4 = new JLabel("HOT: ");
        txtHot4.setBounds(150, 600, 50,25);
        qtyCold4 = new JTextField("0");
        qtyCold4.setBounds(260, 600, 25, 25);
        qtyCold4.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(qtyCold4.getText().trim().equals("0")){
                    qtyCold4.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(qtyCold4.getText().trim().equals("")){
                    qtyCold4.setText("0");
                }
            }
        });
        txtCold4 = new JLabel("COLD: ");
        txtCold4.setBounds(215, 600, 50, 25);

//----------------add-------------------------------

        jp.add(title); jp.add(cartButton);

        jp.add(pic21); jp.add(pic22); jp.add(pic23); jp.add(pic24);
        jp.add(name21); jp.add(name22); jp.add(name23); jp.add(name24);
        jp.add(desc21); jp.add(desc22); jp.add(desc23); jp.add(desc24);
        jp.add(cb21); jp.add(cb22); jp.add(cb23); jp.add(cb24);
        jp.add(qtyHot1); jp.add(qtyHot2); jp.add(qtyHot3); jp.add(qtyHot4);
        jp.add(qtyCold1); jp.add(qtyCold2); jp.add(qtyCold3); jp.add(qtyCold4);
        jp.add(txtHot1); jp.add(txtHot2); jp.add(txtHot3); jp.add(txtHot4);
        jp.add(txtCold1); jp.add(txtCold2); jp.add(txtCold3); jp.add(txtCold4);

        jp.setLayout(null);
        add(jp);
        //-----scrollpane-----
        //scrollPane(jp);
        /*JScrollPane js = new JScrollPane(jp);
        js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        js.setPreferredSize(new Dimension(450, 650));
        add(js);*/
    }

    int flag1 = 0, flag2 = 0, flag3 = 0, flag4 = 0,
            flag11 = 0, flag12 = 0, flag13 = 0, flag14 = 0,
            flag21 = 0, flag22 = 0, flag23 = 0, flag24 = 0;//system not checking the same thing
    public void actionPerformed(ActionEvent e){
        if(cb1.isSelected() && flag1 == 0){
            try{
                int y = Integer.parseInt(qty1.getText());
                String y1 = pic1.getText();
                double y2 = price1;
                storeCart(y, y1, y2);
                flag1 = 1;
            }
            catch (NumberFormatException nfe){
                popUp();
                cb1.setSelected(false);
            }
        }
        else if(cb2.isSelected() && flag2 == 0){
            try{
                int z = Integer.parseInt(qty2.getText());
                String z1 = pic2.getText();
                double z2 = price2;
                storeCart(z, z1, z2);
                flag2 = 1;
            }
            catch (NumberFormatException nfe){
                popUp();
                cb2.setSelected(false);
            }
        }

        else if(cb3.isSelected() && flag3 == 0){
            try{
                int za = Integer.parseInt(qty3.getText());
                String za1 = pic3.getText();
                double za2 = price3;
                storeCart(za, za1, za2);
                flag3 = 1;
            }
            catch (NumberFormatException nfe){
                popUp();
                cb3.setSelected(false);
            }
        }

        else if(cb4.isSelected() && flag4 == 0){
            try{
                int zb = Integer.parseInt(qty4.getText());
                String zb1 = pic4.getText();
                double zb2 = price4;
                storeCart(zb, zb1, zb2);
                flag4 = 1;
            }
            catch (NumberFormatException nfe){
                popUp();
                cb4.setSelected(false);
            }
        }

        else if(!cb1.isSelected() && flag1 == 1) {
            String del = pic1.getText();
            removeCart(del);
            flag1 = 0;
        }

        else if(!cb2.isSelected() && flag2 == 1) {
            String del = pic2.getText();
            removeCart(del);
            flag2 = 0;
        }

        else if(!cb3.isSelected() && flag3 == 1) {
            String del = pic3.getText();
            removeCart(del);
            flag3 = 0;
        }

        else if(!cb4.isSelected() && flag4 == 1) {
            String del = pic4.getText();
            removeCart(del);
            flag4 = 0;
        }

        else if(cb11.isSelected() && flag11 == 0){
            try{
                int y = Integer.parseInt(qty11.getText());
                String y1 = pic11.getText();
                double y2 = price11;
                storeCart(y, y1, y2);
                flag11 = 1;
            }
            catch (NumberFormatException nfe){
                popUp();
                cb11.setSelected(false);
            }
        }
        else if(cb12.isSelected() && flag12 == 0){
            try{
                int z = Integer.parseInt(qty12.getText());
                String z1 = pic12.getText();
                double z2 = price12;
                storeCart(z, z1, z2);
                flag12 = 1;
            }
            catch (NumberFormatException nfe){
                popUp();
                cb12.setSelected(false);
            }
        }

        else if(cb13.isSelected() && flag13 == 0){
            try{
                int za = Integer.parseInt(qty13.getText());
                String za1 = pic13.getText();
                double za2 = price13;
                storeCart(za, za1, za2);
                flag13 = 1;
            }
            catch (NumberFormatException nfe){
                popUp();
                cb13.setSelected(false);
            }
        }

        else if(cb14.isSelected() && flag14 == 0){
            try{
                int zb = Integer.parseInt(qty14.getText());
                String zb1 = pic14.getText();
                double zb2 = price14;
                storeCart(zb, zb1, zb2);
                flag14 = 1;
            }
            catch (NumberFormatException nfe){
                popUp();
                cb14.setSelected(false);
            }
        }

        else if(!cb11.isSelected() && flag11 == 1) {
            String del = pic11.getText();
            removeCart(del);
            flag11 = 0;
        }

        else if(!cb12.isSelected() && flag12 == 1) {
            String del = pic12.getText();
            removeCart(del);
            flag12 = 0;
        }

        else if(!cb13.isSelected() && flag13 == 1) {
            String del = pic13.getText();
            removeCart(del);
            flag13 = 0;
        }

        else if(!cb14.isSelected() && flag14 == 1) {
            String del = pic14.getText();
            removeCart(del);
            flag14 = 0;
        }

        else if(cb21.isSelected() && flag21 == 0) {
            try {
                int y, z, m = 0;
                String y1;
                double y2;
                if (qtyCold1.getText().equals("0") && qtyHot1.getText().equals("0")) {
                    //System.out.println("Qty not entered");
                    popUp();
                    cb21.setSelected(false);
                } else if (qtyCold1.getText().equals("0") || qtyHot1.getText().equals("0")) {
                    if (qtyHot1.getText().equals("0")) { //qtyCold1 is not empty
                        m = Integer.parseInt(qtyCold1.getText());
                        //System.out.println("qtyCold1 is not empty");
                    } else if (qtyCold1.getText().equals("0")) { //qtyHot1 is not empty
                        m = Integer.parseInt(qtyHot1.getText());
                        //System.out.println("qtyHot1 is not empty");
                    }
                    y1 = pic21.getText();
                    y2 = price21;
                    storeCart(m, y1, y2);
                    flag21 = 1;
                } else if (!qtyCold1.getText().equals("0") && !qtyHot1.getText().equals("0")) {
                    y = Integer.parseInt(qtyHot1.getText());
                    z = Integer.parseInt(qtyCold1.getText());
                    //System.out.println(z);
                    m = y + z;
                    y1 = pic21.getText();
                    y2 = price21;
                    storeCart(m, y1, y2);
                }
            }
            catch (NumberFormatException nfe){
                popUp();
                cb21.setSelected(false);
            }
        }
        else if(cb22.isSelected() && flag22 == 0) {
            try {
                int ya, za, ma = 0;
                String ya1;
                double ya2;
                if (qtyCold2.getText().equals("0") && qtyHot2.getText().equals("0")) {
                    //System.out.println("Qty not entered");
                    popUp();
                    cb22.setSelected(false);
                } else if (qtyCold2.getText().equals("0") || qtyHot2.getText().equals("0")) {
                    if (qtyHot2.getText().equals("0")) { //qtyCold2 is not empty
                        ma = Integer.parseInt(qtyCold2.getText());
                        //System.out.println("qtyCold2 is not empty");
                    } else if (qtyCold2.getText().equals("0")) { //qtyHot2 is not empty
                        ma = Integer.parseInt(qtyHot2.getText());
                        //System.out.println("qtyHot2 is not empty");
                    }
                    ya1 = pic22.getText();
                    ya2 = price22;
                    storeCart(ma, ya1, ya2);
                    flag22 = 1;
                } else if (!qtyCold2.getText().equals("0") && !qtyCold2.getText().equals("0")) {
                    ya = Integer.parseInt(qtyHot2.getText());
                    za = Integer.parseInt(qtyCold2.getText());
                    //System.out.println(za);
                    ma = ya + za;
                    ya1 = pic22.getText();
                    ya2 = price22;
                    storeCart(ma, ya1, ya2);
                }
            }
            catch (NumberFormatException nfe){
                popUp();
                cb22.setSelected(false);
            }
        }

        else if(cb23.isSelected() && flag23 == 0) {
            try {
                int yb, zb, mb = 0;
                String yb1;
                double yb2;
                if (qtyCold3.getText().equals("0") && qtyHot3.getText().equals("0")) {
                    //System.out.println("Qty not entered");
                    popUp();
                    cb23.setSelected(false);
                    return;
                } else if (qtyCold3.getText().equals("0") || qtyHot3.getText().equals("0")) {
                    if (qtyHot3.getText().equals("0")) { //qtyCold3 is not empty
                        mb = Integer.parseInt(qtyCold3.getText());
                        //System.out.println("qtyCold3 is not empty");
                    } else if (qtyCold3.getText().equals("0")) { //qtyHot3 is not empty
                        mb = Integer.parseInt(qtyHot3.getText());
                        //System.out.println("qtyHot3 is not empty");
                    }

                } else if (!qtyCold3.getText().equals("0") && !qtyHot3.getText().equals("0")) {
                    yb = Integer.parseInt(qtyHot3.getText());
                    zb = Integer.parseInt(qtyCold3.getText());
                    mb = yb + zb;
                    //System.out.println("Hot:"+yb);
                    //System.out.println("Cold:"+zb);
                }
                yb1 = pic23.getText();
                yb2 = price23;
                storeCart(mb, yb1, yb2);
                flag23 = 1;
            }
            catch (NumberFormatException nfe){
                popUp();
                cb23.setSelected(false);
            }
        }

        else if(cb24.isSelected() && flag24 == 0) {
            try {
                int yc, zc, mc = 0;
                String yc1;
                double yc2;
                if (qtyCold4.getText().equals("0") && qtyHot4.getText().equals("0")) {
                    //System.out.println("Qty not entered");
                    popUp();
                    cb24.setSelected(false);
                    return;
                } else if (qtyCold4.getText().equals("0") || qtyHot4.getText().equals("0")) {
                    if (qtyHot4.getText().equals("0")) { //qtyCold4 is not empty
                        mc = Integer.parseInt(qtyCold4.getText());
                        //System.out.println("qtyCold4 is not empty");
                    } else if (qtyCold4.getText().equals("0")) { //qtyHot4 is not empty
                        mc = Integer.parseInt(qtyHot4.getText());
                        //System.out.println("qtyHot4 is not empty");
                    }
                } else if (!qtyCold4.getText().equals("0") && !qtyHot4.getText().equals("0")) {
                    yc = Integer.parseInt(qtyHot4.getText());
                    zc = Integer.parseInt(qtyCold4.getText());
                    //System.out.println("Hot:"+yc);
                    //System.out.println("Cold:"+zc);
                    mc = yc + zc;
                }
                yc1 = pic24.getText();
                yc2 = price24;
                storeCart(mc, yc1, yc2);
                flag24 = 1;
            }
            catch (NumberFormatException nfe){
                popUp();
                cb24.setSelected(false);
            }
        }

        else if(!cb21.isSelected() && flag21 == 1) {
            String del = pic21.getText();
            removeCart(del);
            flag21 = 0;
        }

        else if(!cb22.isSelected() && flag22 == 1) {
            String del = pic22.getText();
            removeCart(del);
            flag22 = 0;
        }

        else if(!cb23.isSelected() && flag23 == 1) {
            String del = pic23.getText();
            removeCart(del);
            flag23 = 0;
        }

        else if(!cb24.isSelected() && flag24 == 1) {
            String del = pic24.getText();
            removeCart(del);
            flag24 = 0;
        }
    }

    public void popUp(){
        JOptionPane.showMessageDialog(this,"Please enter the quantity", "Please enter the quantity", JOptionPane.WARNING_MESSAGE);
    }

    public void storeCart(int x, String x1, double x2){
        for(int i=0; i<size; i++){
            if(qntty[i]==0){
                qntty[i] = x;
                foodCart[i] = x1;
                priceCart[i] = x2;
                System.out.println(qntty[i] + foodCart[i] + priceCart[i]); //check on console whether num & carList1 value have been stored
                i = size; //stop looping
            }
        }
    }

    //remove item from cart after untick box
    public void removeCart(String del) {
        for (int i=0; i<size; i++) {
            if (foodCart[i].equalsIgnoreCase(del)) {
                qntty[i] = 0;
                foodCart[i] = "";
                priceCart[i] = 0.0;
                System.out.println(qntty[i] + foodCart[i] + priceCart[i]);
                i = size;
            }
        }
    }

    private void backButton(JPanel x){
        Icon home = UIManager.getIcon("FileChooser.homeFolderIcon");
        back1 = new JButton(home);
        back1.setBounds(0, 0, 20, 20);
        back1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CartPage cart = new CartPage();
                cart.cartList(qntty, priceCart, foodCart);
                cart.setVisible(false);
                x.setVisible(false);
                setJPanelMenuPage();
                //dispose();
            }
        });
        x.add(back1);
    }

    /*private void scrollPane(JPanel x){
        JScrollPane js = new JScrollPane(x);
        js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        js.setPreferredSize(new Dimension(450, 650));
        add(js);
    }*/
}

