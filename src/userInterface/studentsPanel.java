/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import DAL.author;
import DAL.bookGenre;
import DAL.publisher;
import Services.servicesAuthor;
import Services.servicesBookGenre;
import Services.servicesBooks;
import Services.servicesPublisher;
import Services.servicesStudents;
import Services.servicesBookDeliverySettings;
import Services.texts;
import javax.swing.table.DefaultTableModel;
import Services.servicesStudentsBook;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author fahri
 */
public class studentsPanel extends javax.swing.JFrame {

    ArrayList<bookGenre> bookGenreList = new ArrayList<>();
    ArrayList<author> authorList = new ArrayList<>();
    ArrayList<publisher> publisherList = new ArrayList<>();
    servicesStudents sNum = new servicesStudents();
    Date today = new Date();
    DateFormat bas = new SimpleDateFormat("yyyy/MM/dd");
    //private String takeBookLimit = String.valueOf(takeBookLimit);
    public int ID;
    public int bookDeliveryTime;
    public int lateDeliveryPenalty;
    public int takeBookLimit;

    /**
     * Creates new form studentsMainPanel
     */
    public studentsPanel() {
        initComponents();
        String no = String.valueOf(sNum.studentID);
        String name = String.valueOf(sNum.studentName);
        lblStudentID.setText(name);
        delivery();
        lblTakeBookLimit.setText(new texts().bookLimit() + takeBookLimit + " )");
        List();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTakeBookLimit = new javax.swing.JLabel();
        lblDelayPenalty = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBookList = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStudentsBookList = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtBookName = new javax.swing.JTextField();
        txtISBN_No = new javax.swing.JTextField();
        txtBookStatus = new javax.swing.JTextField();
        lblBookName = new javax.swing.JLabel();
        lblBookGenre = new javax.swing.JLabel();
        lblAuthor = new javax.swing.JLabel();
        lblISBN_No = new javax.swing.JLabel();
        lblBookStatus = new javax.swing.JLabel();
        lblPublisher = new javax.swing.JLabel();
        comboBxBookGenre = new javax.swing.JComboBox<>();
        comboBxAuthor = new javax.swing.JComboBox<>();
        comboBxPublisher = new javax.swing.JComboBox<>();
        backPage = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnDeliveryBook = new javax.swing.JButton();
        btnTakeBook = new javax.swing.JButton();
        btnList = new javax.swing.JButton();
        lblStudentID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(new texts().StudentsScreenHead());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblTakeBookLimit.setText(new texts().takeBookLimit());

        lblDelayPenalty.setText(new texts().penalty());

        tblBookList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBookList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBookListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBookList);
        if (tblBookList.getColumnModel().getColumnCount() > 0) {
            tblBookList.getColumnModel().getColumn(0).setResizable(false);
            tblBookList.getColumnModel().getColumn(0).setHeaderValue(new texts().ID()
            );
            tblBookList.getColumnModel().getColumn(1).setResizable(false);
            tblBookList.getColumnModel().getColumn(1).setHeaderValue(new texts().bookName());
            tblBookList.getColumnModel().getColumn(2).setResizable(false);
            tblBookList.getColumnModel().getColumn(2).setHeaderValue(new texts().bookGenre());
            tblBookList.getColumnModel().getColumn(3).setResizable(false);
            tblBookList.getColumnModel().getColumn(3).setHeaderValue(new texts().authorName());
            tblBookList.getColumnModel().getColumn(4).setResizable(false);
            tblBookList.getColumnModel().getColumn(4).setHeaderValue(new texts().ISBN_NO());
            tblBookList.getColumnModel().getColumn(5).setResizable(false);
            tblBookList.getColumnModel().getColumn(5).setHeaderValue(new texts().bookStatus());
            tblBookList.getColumnModel().getColumn(6).setResizable(false);
            tblBookList.getColumnModel().getColumn(6).setHeaderValue(new texts().publisher());
        }

        tblStudentsBookList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", "", "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStudentsBookList.getTableHeader().setReorderingAllowed(false);
        tblStudentsBookList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentsBookListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblStudentsBookList);
        if (tblStudentsBookList.getColumnModel().getColumnCount() > 0) {
            tblStudentsBookList.getColumnModel().getColumn(0).setResizable(false);
            tblStudentsBookList.getColumnModel().getColumn(0).setHeaderValue(new texts().ID());
            tblStudentsBookList.getColumnModel().getColumn(1).setResizable(false);
            tblStudentsBookList.getColumnModel().getColumn(1).setHeaderValue(new texts().bookName());
            tblStudentsBookList.getColumnModel().getColumn(2).setResizable(false);
            tblStudentsBookList.getColumnModel().getColumn(2).setHeaderValue(new texts().bookGenre());
            tblStudentsBookList.getColumnModel().getColumn(3).setResizable(false);
            tblStudentsBookList.getColumnModel().getColumn(3).setHeaderValue(new texts().authorName());
            tblStudentsBookList.getColumnModel().getColumn(4).setResizable(false);
            tblStudentsBookList.getColumnModel().getColumn(4).setHeaderValue(new texts().ISBN_NO());
            tblStudentsBookList.getColumnModel().getColumn(5).setResizable(false);
            tblStudentsBookList.getColumnModel().getColumn(5).setHeaderValue(new texts().bookStatus());
            tblStudentsBookList.getColumnModel().getColumn(6).setResizable(false);
            tblStudentsBookList.getColumnModel().getColumn(6).setHeaderValue(new texts().publisher());
            tblStudentsBookList.getColumnModel().getColumn(7).setResizable(false);
            tblStudentsBookList.getColumnModel().getColumn(7).setHeaderValue(new texts().studentsName());
            tblStudentsBookList.getColumnModel().getColumn(8).setResizable(false);
            tblStudentsBookList.getColumnModel().getColumn(8).setHeaderValue(new texts().dateOfBook());
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new texts().bookInfo()));
        jPanel1.setEnabled(false);

        lblID.setText(new texts().ID());
        lblID.setEnabled(false);

        txtID.setEnabled(false);

        txtBookName.setEnabled(false);

        txtISBN_No.setEnabled(false);

        txtBookStatus.setEnabled(false);

        lblBookName.setText(new texts().bookName());
        lblBookName.setEnabled(false);

        lblBookGenre.setText(new texts().bookGenre());
        lblBookGenre.setEnabled(false);

        lblAuthor.setText(new texts().authorName());
        lblAuthor.setEnabled(false);

        lblISBN_No.setText(new texts().ISBN_NO());
        lblISBN_No.setEnabled(false);

        lblBookStatus.setText(new texts().bookStatus());
        lblBookStatus.setEnabled(false);

        lblPublisher.setText(new texts().publisher());
        lblPublisher.setEnabled(false);

        comboBxBookGenre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBxBookGenre.setEnabled(false);

        comboBxAuthor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBxAuthor.setEnabled(false);

        comboBxPublisher.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBxPublisher.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblBookGenre)
                        .addComponent(lblAuthor)
                        .addComponent(lblISBN_No)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBookStatus))
                        .addComponent(lblBookName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblPublisher))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboBxPublisher, 0, 202, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtBookName, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtID, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtISBN_No, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtBookStatus, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(comboBxBookGenre, 0, 202, Short.MAX_VALUE)
                        .addComponent(comboBxAuthor, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBookName))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBookGenre)
                    .addComponent(comboBxBookGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBxAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAuthor))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtISBN_No, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblISBN_No))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBookStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBookStatus))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPublisher)
                    .addComponent(comboBxPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        backPage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back.png"))); // NOI18N
        backPage.setToolTipText("");
        backPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backPageActionPerformed(evt);
            }
        });

        btnDeliveryBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hand-give.png"))); // NOI18N
        btnDeliveryBook.setText(new texts().btnDeliveryBook());
        btnDeliveryBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeliveryBookActionPerformed(evt);
            }
        });

        btnTakeBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hand-over.png"))); // NOI18N
        btnTakeBook.setText(new texts().btnTakeBook());
        btnTakeBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTakeBookActionPerformed(evt);
            }
        });

        btnList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/liste.png"))); // NOI18N
        btnList.setText(new texts().btnList());
        btnList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnList)
                    .addComponent(btnDeliveryBook)
                    .addComponent(btnTakeBook))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(btnList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeliveryBook)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTakeBook)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(backPage, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 903, Short.MAX_VALUE)
                .addComponent(lblStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTakeBookLimit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDelayPenalty, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(172, 172, 172))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backPage, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStudentID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTakeBookLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(lblDelayPenalty)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );

        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void delivery() {
        servicesBookDeliverySettings a = new servicesBookDeliverySettings();
        int[] b = a.list(ID, bookDeliveryTime, lateDeliveryPenalty, takeBookLimit);
        ID = b[0];
        bookDeliveryTime = b[1];
        lateDeliveryPenalty = b[2];
        takeBookLimit = b[3];
    }
    private void backPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backPageActionPerformed
        // TODO add your handling code here:
        studentsEntry panel = new studentsEntry();
        panel.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backPageActionPerformed

    public void Date(String takeDate) {
        LocalDate now = LocalDate.now();
        LocalDate firstDate = LocalDate.parse(takeDate);
        long ceza = ChronoUnit.DAYS.between(firstDate, now);
        if (ceza < lateDeliveryPenalty) {
            lblDelayPenalty.setText(new texts().noPenalty());
        } else {
            long ode = ceza * 3;
            lblDelayPenalty.setText(new texts().yourPenalty() + ode + new texts().penaltyCurrency());
        }
    }

    private void btnTakeBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTakeBookActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tblStudentsBookList.getModel();
        lblTakeBookLimit.setText(new texts().takeBookLimit() + takeBookLimit + " )");
        if (model.getRowCount() < takeBookLimit) {
            String BookID = txtID.getText().trim();
            int bookID = Integer.parseInt(BookID);
            String bookName = txtBookName.getText().trim();
            String ISBN_NO = txtISBN_No.getText().trim();
            int ISBN_No = Integer.parseInt(ISBN_NO);
            String BookStatus = txtBookStatus.getText().trim();
            String StudentID = lblStudentID.getText().trim();
            int studentID = sNum.studentID;
            int bookGenreIndex = comboBxBookGenre.getSelectedIndex();
            if (bookGenreIndex <= 0) {
                JOptionPane.showMessageDialog(null, new texts().selectLine());
                return;
            }
            bookGenre bookGenre = bookGenreList.get(bookGenreIndex - 1);

            int authorIndex = comboBxAuthor.getSelectedIndex();
            if (authorIndex <= 0) {
                JOptionPane.showMessageDialog(null, new texts().selectLine());
                return;
            }
            DAL.author valueOfAuthor = authorList.get(authorIndex - 1);

            int publisherIndex = comboBxPublisher.getSelectedIndex();
            if (publisherIndex <= 0) {
                JOptionPane.showMessageDialog(null, new texts().selectLine());
                return;
            }
            DAL.publisher valueOfPublisher = publisherList.get(publisherIndex - 1);

            String takeDate = (bas.format(today));
            String with = new texts().withStudent();
            new servicesBooks().vtUpdateStudent(bookID, with);
            servicesStudentsBook book = new servicesStudentsBook();
            book.vtAdd(studentID, bookID, bookName, bookGenre.getBookGenreID(), valueOfAuthor.getAuthorID(), ISBN_No, BookStatus, valueOfPublisher.getPublisherID(), takeDate);
            new servicesStudentsBook().vtUpdateStudent(bookID, with);
            takeBookLimit -= 1;
        } else {
            lblTakeBookLimit.setText("alınabilir kitap limti  dolduğu için kitap alamazsınız");
        }
        List();
        Clean();
    }//GEN-LAST:event_btnTakeBookActionPerformed

    private void tblBookListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBookListMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tblBookList.getModel();
        int selected = tblBookList.getSelectedRow();
        txtID.setText(model.getValueAt(selected, 0).toString());
        txtBookName.setText(model.getValueAt(selected, 1).toString());
        txtISBN_No.setText(model.getValueAt(selected, 4).toString());
        txtBookStatus.setText(model.getValueAt(selected, 5).toString());
        int ID = Integer.parseInt(model.getValueAt(selected, 0).toString());
        int[] bookGenre = new servicesBooks().GetBookGenreByID(ID);
        int bookGenreIndex = 0;

        for (int i = 0; i < bookGenreList.size(); i++) {
            if (bookGenreList.get(i).getBookGenreID() == bookGenre[0]) {
                bookGenreIndex = i;
                break;
            }
        }
        comboBxBookGenre.setSelectedIndex(bookGenreIndex + 1);

        int[] author = new servicesBooks().GetBookAuthorByID(ID);
        int authorIndex = 0;
        for (int i = 0; i < authorList.size(); i++) {
            if (authorList.get(i).getAuthorID() == author[0]) {
                authorIndex = i;
                break;
            }
        }
        comboBxAuthor.setSelectedIndex(authorIndex + 1);

        int[] publisher = new servicesBooks().getPublisherByID(ID);
        int publisherIndex = 0;
        for (int i = 0; i < publisherList.size(); i++) {
            if (publisherList.get(i).getPublisherID() == publisher[0]) {
                publisherIndex = i;
                break;
            }
        }
        comboBxPublisher.setSelectedIndex(publisherIndex + 1);


    }//GEN-LAST:event_tblBookListMouseClicked

    private void tblStudentsBookListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentsBookListMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tblStudentsBookList.getModel();
        int selected = tblStudentsBookList.getSelectedRow();
        
        txtID.setText(model.getValueAt(selected, 0).toString());
        txtBookName.setText(model.getValueAt(selected, 1).toString());
        txtISBN_No.setText(model.getValueAt(selected, 4).toString());
        txtBookStatus.setText(model.getValueAt(selected, 5).toString());
        lblStudentID.setText(model.getValueAt(selected, 7).toString());
        int ID = Integer.parseInt(model.getValueAt(selected, 0).toString());
        int[] bookGenre = new servicesBooks().GetBookGenreByID(ID);

        int bookGenreIndex = 0;
        for (int i = 0; i < bookGenreList.size(); i++) {
            if (bookGenreList.get(i).getBookGenreID() == bookGenre[0]) {
                bookGenreIndex = i;
                break;
            }
        }
        comboBxBookGenre.setSelectedIndex(bookGenreIndex + 1);
        int[] author = new servicesBooks().GetBookAuthorByID(ID);
        int authorIndex = 0;
        for (int i = 0; i < authorList.size(); i++) {
            if (authorList.get(i).getAuthorID() == author[0]) {
                authorIndex = i;
                break;
            }
        }
        comboBxAuthor.setSelectedIndex(authorIndex + 1);
        int[] publisher = new servicesBooks().getPublisherByID(ID);
        int publisherIndex = 0;
        for (int i = 0; i < publisherList.size(); i++) {
            if (publisherList.get(i).getPublisherID() == publisher[0]) {
                publisherIndex = i;
                break;
            }
        }
        comboBxPublisher.setSelectedIndex(publisherIndex + 1);
        String date = model.getValueAt(selected, 8).toString();
        Date(date);

    }//GEN-LAST:event_tblStudentsBookListMouseClicked

    private void btnDeliveryBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeliveryBookActionPerformed
        // TODO add your handling code here:
        String SelectedID = txtID.getText().trim();
        String BookID = txtID.getText().trim();
        int bookID = Integer.parseInt(BookID);
        if (BookID != null && BookID.length() > 0) {
            int ID = Integer.parseInt(BookID);
            String with = new texts().withSchol();
            new servicesBooks().vtUpdateStudent(bookID, with);
            new servicesStudentsBook().vtDelete(ID);
            takeBookLimit += 1;

        } else {
            JOptionPane.showMessageDialog(null, new texts().selectLine());
        }
        List();
        Clean();
    }//GEN-LAST:event_btnDeliveryBookActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        servicesBookGenre bGenre = new servicesBookGenre();
        DefaultComboBoxModel modelGenre = (DefaultComboBoxModel) comboBxBookGenre.getModel();
        bookGenreList = bGenre.load(modelGenre);

        servicesAuthor author = new servicesAuthor();
        DefaultComboBoxModel modelAuthor = (DefaultComboBoxModel) comboBxAuthor.getModel();
        authorList = author.load(modelAuthor);

        servicesPublisher publisher = new servicesPublisher();
        DefaultComboBoxModel modelPublisher = (DefaultComboBoxModel) comboBxPublisher.getModel();
        publisherList = publisher.load(modelPublisher);
        List();

    }//GEN-LAST:event_formWindowOpened

    private void btnListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListActionPerformed
        // TODO add your handling code here:
        List();
        Clean();
    }//GEN-LAST:event_btnListActionPerformed

    public void List() {
        DefaultTableModel modelStudents = (DefaultTableModel) tblStudentsBookList.getModel();
        new servicesStudentsBook().bring(sNum.studentID, modelStudents);
        DefaultTableModel modelAll = (DefaultTableModel) tblBookList.getModel();
        new servicesBooks().bringForStudent(modelAll);
        lblTakeBookLimit.setText("alınabilir kitap sayısı ( " + takeBookLimit + " )");

    }

    public void Clean() {
        txtID.setText("");
        txtBookName.setText("");
        txtBookStatus.setText("");
        txtISBN_No.setText("");
        comboBxBookGenre.setSelectedIndex(0);
        comboBxAuthor.setSelectedIndex(0);
        comboBxPublisher.setSelectedIndex(0);

    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(studentsPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(studentsPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(studentsPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(studentsPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new studentsPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backPage;
    private javax.swing.JButton btnDeliveryBook;
    private javax.swing.JButton btnList;
    private javax.swing.JButton btnTakeBook;
    private javax.swing.JComboBox<String> comboBxAuthor;
    private javax.swing.JComboBox<String> comboBxBookGenre;
    private javax.swing.JComboBox<String> comboBxPublisher;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAuthor;
    private javax.swing.JLabel lblBookGenre;
    private javax.swing.JLabel lblBookName;
    private javax.swing.JLabel lblBookStatus;
    private javax.swing.JLabel lblDelayPenalty;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblISBN_No;
    private javax.swing.JLabel lblPublisher;
    private javax.swing.JLabel lblStudentID;
    private javax.swing.JLabel lblTakeBookLimit;
    private javax.swing.JTable tblBookList;
    private javax.swing.JTable tblStudentsBookList;
    private javax.swing.JTextField txtBookName;
    private javax.swing.JTextField txtBookStatus;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtISBN_No;
    // End of variables declaration//GEN-END:variables

}
