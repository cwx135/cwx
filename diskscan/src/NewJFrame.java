


import java.awt.AWTException;
import java.awt.BasicStroke;
import static java.awt.Color.BLACK;
import static java.awt.Color.GREEN;
import static java.awt.Color.RED;
import static java.awt.EventQueue.invokeLater;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import static java.awt.Toolkit.getDefaultToolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import static java.io.File.listRoots;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import static java.lang.System.exit;
import java.util.Arrays;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileSystemView;
import static javax.swing.filechooser.FileSystemView.getFileSystemView;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class NewJFrame extends javax.swing.JFrame {

    String source;
    File[] files;
    String path;        // 磁盘路径
    long totalSpace;    // 总空间大小
    long freeSpace;     // 剩余空间大小 
    long usedSpace;     // 已用空间大小
    File file;      //磁盘路径
    int i1;     //文件夹数
    String destDirName;
    Thread copy;
    Thread comp;
    boolean stop1;
    boolean stop2;
    ImageIcon imagebad;
    ImageIcon imageok;
    BufferedImage image;
    BufferedImage iok;
    BufferedImage ibad;

    int ok1;
    int bad1;
    File fok;
    Byte[] data1;
    private final byte[] data = new byte[1048576];

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {

        this.setTitle("磁盘检测软件");
        initComponents();
        findURootPath();
        imagebad = new ImageIcon("src\\3.png");
        imageok = new ImageIcon("src\\4.png");
        source = "src\\test.bin";
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

    }
    
    //画图
    private void img() {
        Graphics graphics = jPanel1.getGraphics();
        ((Graphics2D) graphics).setColor(GREEN);
        ((Graphics2D) graphics).fillRect(1, 1, 10, 17);
        ((Graphics2D) graphics).setStroke(new BasicStroke(1));
        ((Graphics2D) graphics).setColor(BLACK);
        ((Graphics2D) graphics).drawRect(1, 1, 10, 17);

        Graphics graphics1 = jPanel2.getGraphics();
        ((Graphics2D) graphics1).setColor(RED);
        ((Graphics2D) graphics1).fillRect(1, 1, 10, 17);
        ((Graphics2D) graphics1).setStroke(new BasicStroke(1));
        ((Graphics2D) graphics1).setColor(BLACK);
        ((Graphics2D) graphics1).drawRect(1, 1, 10, 17);

    }
    
    //获取屏幕截图
    private void copy() {

        Point p = this.getLocation();
        int x = (int) p.getX() + jPanel1.getX();
        int y = (int) p.getY() + jPanel1.getY();
       
        try {
            Robot robot = new Robot();
            Toolkit toolkit = getDefaultToolkit();
            Rectangle rect = new Rectangle(0, 0, toolkit.getScreenSize().width, toolkit.getScreenSize().height);
            image = robot.createScreenCapture(rect);

        } catch (AWTException e) {
        }
        //将截图装载到icon
        if (image != null) {
            iok = image.getSubimage(x + 8, y + 30, 12, 19);
            ibad = image.getSubimage(x + 8, y + 70, 12, 19);
        }
    }

    //磁盘路径
    private void findURootPath() {
        File[] discstem = listRoots();
        FileSystemView fileSystemView = getFileSystemView(); // 获取FileSystemView对象
        for (File f1 : discstem) {
            // 获取磁盘的类型描述信息
            String diskType = fileSystemView.getSystemTypeDescription(f1);
            //盘符类型包括：本地磁盘、可移动磁盘、CD 驱动器等
            if (diskType.equals("可移动磁盘")) {
                path = f1.toString();
                if (jComboBox1.getSelectedItem() != path) {
                    jComboBox1.addItem(path);
                    path = jComboBox1.getSelectedItem().toString();
                }
                file = new File(path);
                totalSpace = file.getTotalSpace();
                freeSpace = file.getFreeSpace();
                usedSpace = totalSpace - freeSpace;
                jTextField1.setText(jComboBox1.getSelectedItem() + "    总空间大小 : " + totalSpace / 1024 / 1024 + "MB   " + " 剩余空间大小 : "
                        + freeSpace / 1024 / 1024 + "MB   " + " 已用空间大小 : " + usedSpace / 1024 / 1024 + "MB ");
                files = file.listFiles();
                i1 = files.length;
                jLabel3.setText("文件数： " + Integer.toString(i1));
            } else {
                jTextField1.setText("请插入可移动磁盘！");
            }
            destDirName = path + "test";
        }

        for (int i = 0; i < 1048576; i++) {
            data[i] = (byte) 0xFF;
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setEnabled(false);
        jScrollPane1.setOpaque(false);
        jScrollPane1.setRequestFocusEnabled(false);
        jScrollPane1.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setWheelScrollingEnabled(false);

        jTextPane1.setEditable(false);
        jTextPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextPane1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jTextPane1.setDropMode(javax.swing.DropMode.INSERT);
        jTextPane1.setEnabled(false);
        jTextPane1.setFocusCycleRoot(false);
        jTextPane1.setFocusable(false);
        jTextPane1.setHighlighter(null);
        jTextPane1.setKeymap(null);
        jTextPane1.setLogicalStyle(null);
        jTextPane1.setOpaque(false);
        jTextPane1.setRequestFocusEnabled(false);
        jTextPane1.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(jTextPane1);

        jButton1.setText("更新");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("复制");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("当前磁盘：");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTextField1.setVerifyInputWhenFocusTarget(false);

        jLabel2.setText("完成：");

        jLabel3.setText("总文件数：");

        jLabel4.setText("当前数：");

        jLabel5.setText("好：");

        jLabel6.setText("坏：");

        jLabel7.setText("用时：");

        jButton3.setText("检测");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("退出");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(15, 22));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setPreferredSize(new java.awt.Dimension(15, 22));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(202, 202, 202)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(22, 22, 22))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(0, 146, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       //刷新
        findURootPath();
        img();
        copy();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //复制文件
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);

        File dir = new File(destDirName);
        //创建目录  
        if (dir.mkdirs()) {
            //jLabel5.setText("创建目录 " + destDirName + " 成功！");
        } else {
            // jLabel5.setText("创建目录 " + destDirName + " 已存在！");
        }
        stop1 = true;
        copy = new copyfiles();
        copy.start();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //检测
        img();
        copy();
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        ok1 = 0;
        bad1 = 0;
        stop2 = true;
        comp = new compfiles();
        comp.start();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //退出
        exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        //选择磁盘
        path = jComboBox1.getSelectedItem().toString();
        file = new File(path);
        totalSpace = file.getTotalSpace();
        freeSpace = file.getFreeSpace();
        usedSpace = totalSpace - freeSpace;
        jTextField1.setText(jComboBox1.getSelectedItem() + "    总空间大小 : " + totalSpace / 1024 / 1024 + "MB   " + " 剩余空间大小 : "
                + freeSpace / 1024 / 1024 + "MB   " + " 已用空间大小 : " + usedSpace / 1024 / 1024 + "MB ");
        files = file.listFiles();
        i1 = files.length;
        jLabel3.setText("文件数： " + Integer.toString(i1));
        destDirName = path + "test";

    }//GEN-LAST:event_jComboBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        invokeLater(() -> {
            new NewJFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JButton jButton3;
    public javax.swing.JButton jButton4;
    public javax.swing.JComboBox<String> jComboBox1;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField jTextField1;
    public javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables

    class copyfiles extends Thread {

        private String dest;
        private int i2 = 1;

        @Override
        public void run() {
            InputStream input;
            OutputStream output;
            jLabel3.setText("文件总数： " + Long.toString(freeSpace / 1024 / 1024));
            input = new ByteArrayInputStream(data);

            while (stop1) {
                try {
                    dest = destDirName + "//" + Integer.toString(i2) + ".bin";
                    output = new FileOutputStream(dest);
                    byte[] buf = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = input.read(buf)) > 0) {
                        output.write(buf, 0, bytesRead);
                    }
                    output.close();
                } catch (FileNotFoundException ex) {
                    getLogger(NewJFrame.class.getName()).log(SEVERE, null, ex);
                } catch (IOException ex) {
                    getLogger(NewJFrame.class.getName()).log(SEVERE, null, ex);
                }
                i2 += 1;
                jLabel4.setText("当前数： " + Integer.toString(i2));
                if (i2 > freeSpace / 1024 / 1024) {
                    stop1 = false;
                }
            }
            jButton3.setEnabled(true);
            jLabel2.setText("重新插入U盘。。");
        }
    }

    class compfiles extends Thread {

        private String dest;
        String temp;
        private int i2 = 1;
        File file;
        File[] files;
        int i3;
        private int i4 = 1;
        int bytesRead;
        private Document docs;
        SimpleAttributeSet attrset;
        StyledDocument inputSDoc1;
        StyledDocument inputSDoc2;
        StyledDocument outSDoc;
        StyledDocument doc;

        compfiles() {
            file = new File(destDirName);
            files = file.listFiles();
            i1 = files.length;
            this.i3 = i1;
            jLabel3.setText("文件总数： " + Integer.toString(i3));
        }

        @Override
        public void run() {

            while (stop2) {
                dest = destDirName + "\\" + Integer.toString(i2) + ".bin";

                if (i4 == 50) {
                    jTextPane1.getCaretPosition();
                    docs = jTextPane1.getDocument();//获得文本对象
                    try {
                        docs.insertString(docs.getLength(), "\n", attrset);//对文本进行追加
                    } catch (BadLocationException e) {
                    }
                    i4 = 1;
                }
                
                //读取要检测文件
                byte[] data2 = null;
                try {
                    //System.out.println(dest);
                    File f2 = new File(dest);
                    int length1 = (int) f2.length();
                    data2 = new byte[length1];
                    try (InputStream inputStream = new FileInputStream(f2)) {
                        inputStream.read(data2);
                        inputStream.close();
                    }
                } catch (IOException e) {
                }

                if (Arrays.equals(data, data2)) {
                    jTextPane1.setCaretPosition(jTextPane1.getStyledDocument().getLength());
                    jTextPane1.insertIcon(new ImageIcon(iok));//插入icon元素

                    //删除已经检测好的文件
                    File f3 = new File(dest);
                    if (f3.exists() && f3.isFile()) {
                        if (f3.delete()) {
                            jLabel2.setText("成功！");
                        } else {
                            jLabel2.setText("失败！");
                        }
                    } else {
                        jLabel2.setText("没有文件！");
                    }
                    
                    ok1 += 1;
                    jLabel5.setText("好： " + ok1);
                    jLabel4.setText("当前数： " + Integer.toString(i2));
                } else {
                    jTextPane1.setCaretPosition(jTextPane1.getStyledDocument().getLength());
                    jTextPane1.insertIcon(new ImageIcon(ibad));//插入icon元素

                    bad1 += 1;
                    jLabel6.setText("坏： " + bad1);
                    jLabel4.setText("当前数： " + Integer.toString(i2));

                }
                if (i2 == i1) {
                    stop2 = false;
                }
                i2 += 1;
                i4 += 1;

            }
            jButton3.setEnabled(true);
            jButton4.setEnabled(true);
            jButton2.setEnabled(true);
            jButton1.setEnabled(true);
        }
    }

}
