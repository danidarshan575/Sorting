import javax.swing.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class InputPage extends javax.swing.JFrame {

    JFrame JF2 = new JFrame();

    // Create new form InputPage

    public InputPage() {
        initComponents();
    }

    public void initComponents() {

        jLabelArray = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaIPArray = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        JF2.add(jLabelArray);                           // This whole frame can be deleted later as it is not closing gracefully.
        JF2.add(jScrollPane1);
        JF2.add(jTextAreaIPArray);
        JF2.add(jLabel1);
        JF2.add(jLabel2);
        JF2.add(jButton1);
        JF2.pack();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelArray.setText("Elements :");

        jTextAreaIPArray.setColumns(20);
        jTextAreaIPArray.setRows(5);
        jTextAreaIPArray.setToolTipText("Enter elements here separated by a comma ");
        jScrollPane1.setViewportView(jTextAreaIPArray);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Please enter the elements.");

        jLabel2.setText("Enter comma separated values and click next on 'Sort' when done");

        jButton1.setText("Sort ");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabelArray)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)))
                                .addContainerGap(21, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(158, 158, 158))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel1)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel2)
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelArray))
                                .addGap(30, 30, 30)
                                .addComponent(jButton1)
                                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        // This is the 'Sort' button

        Data data = new Data();
        Sorts sorts = new Sorts();
        int n = data.getNoOfNumbers();
        System.out.println("No of numbers as received from data :" + n);
        String sortType = data.getSort();
        System.out.println("Sort type as received from data :" + sortType);

        int[] inputelements = new int[n];

        String temp = jTextAreaIPArray.getText();
        System.out.println("The originally entered numbers are :" + temp);
        StringTokenizer st = new StringTokenizer(temp, ",");

        while (st.hasMoreTokens()) {
            for (int j = 0; j < inputelements.length; j++) {
                inputelements[j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(Arrays.toString(inputelements));
        data.setInput(inputelements);

        // For showing that the data is successfully passed.
        System.out.println("Data write successful. Here's what you entered :" + Arrays.toString(data.getInput()));

        sortSwitch();
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InputPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InputPage().setVisible(true);
            }
        });
    }

    public void sortSwitch(){
        Data data = new Data();
        Sorts sorts = new Sorts();
        String sortType = data.getSort();

        switch (sortType) {
            case ("Merge Sort"):
                sorts.mergeSort(data.getInput(), data.getNoOfNumbers());
                break;

            case ("Heap Sort"):
                sorts.heapSort(data.getInput());
                break;

            case("Quick sort"):
                sorts.quickSort(data.getInput(),0,data.getInput().length-1);
                break;

            case("Quick sort with 3 medians"):
                sorts.quickSort3med(data.getInput());
                break;

            case ("Insertion sort"):
                sorts.insertionSort(data.getInput());
                break;

            case ("Selection sort"):
                sorts.selectionSort(data.getInput());
                break;

            case ("Bubble Sort"):
                sorts.bubbleSort(data.getInput());
                break;
        }
    }
    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelArray;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaIPArray;
    // End of variables declaration
}
