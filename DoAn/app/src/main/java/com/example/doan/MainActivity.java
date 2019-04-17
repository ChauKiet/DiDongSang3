package com.example.doan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txt_coin;
    private TextView txt_heart;
    private TextView txt_ketQua;
    private int coin = 0;
    private int heart = 5;
    private int i = 0;
    private int dem = 0;
    private LinearLayout layout_4;
    private LinearLayout layout_5;
    private LinearLayout layout_3;
    private LinearLayout layout_2;
    private LinearLayout layout_button;
    private Button btnChoose;
    private final String[] DAP_AN ={
            "HOIDONG",
            "AOMUA",
            "BAOCAO",
            "OTO",
            "DANONG",
            "XAKEP",
            "XAPHONG",
            "TOHOAI",
            "CANTHIEP",
            "CATTUONG",
            "DANHLUA",
            "TICHPHAN",
            "QUYHANG",
            "GIANGMAI",
            "GIANDIEP",
            "SONGSONG",
            "THOTHE",
            "THATTINH",
            "TRANHTHU",
            "TOTIEN",
            "MASAT",
            "HONGTAM",
            "BAOLA",
            "KINHDO",
            "HUNGTHU",
            "TINHTRUONG",
            "BAOQUAT",
            "CAUMAY",
            "NHACCU",
            "NOITHAT",
            "DAUTHU",
            "NEMDADAUTAY",
            "BAOPHU",
            "LANGTHANG",
            "CHIDIEM",
            "CONGTRAI",
            "BADONG",
            "THANKHOC",
            "AIMO",
            "THONGTAN",
            "BAOTU",
            "MUINHON",
            "LUCLAC",
            "THOO",
            "NHAHAT",
            "BAOTHUC",
            "BONGDA",
            "BACTINH",
            "HAILONG",
            "BIOI",
            "NGANGU",
            "BINHHOADIDONG",
            "DONGCAMCONGKHO",
            "TRAUMONG",
            "NGUAO",
            "BAXA",
            "XEHOA",
            "COBAP",
            "XUONGRONG",
            "HANHHA",
            "DETIEN",
            "NHANDUC",
            "TAIHOA",
            "CHANTUONG",
            "BAMOI",
            "CONGBO",
            "BINHCHANNHUVAI",
            "KHOANHONG",
            "HAMHAU",
            "HINHBINHHANH",
            "MATKHAU",
            "TANGCA",
            "THICHTHU",
            "NHANTU",
            "BAODONG",
            "KEOCUALUAXE",
            "CAOKIEN",
            "QUYCU",
            "NANGLONG",
            "CANDAUVAN",
            "MAHOA",
            "MACARONG",
            "COHOI",
            "THAMHOA",
            "MATUY",
            "TUNGTANG",
            "RUATIEN",
            "BINHYEN",
            "XALAN",
            "VUONBACHTHU",
            "NHAGIAO",
            "MOITRUONG",
            "MANOCANH",
            "TIENDAO",
            "BAONGU",
            "DINHCONG",
            "ANMAY",
            "THACHCAO",
            "XEDIEU",
            "HOANGTHAT",

    };
    public static final int[] QUESTIONS={
            R.drawable.hoidong,
            R.drawable.aomua,
            R.drawable.baocao,
            R.drawable.oto,
            R.drawable.danong,
            R.drawable.xakep,
            R.drawable.xaphong,
            R.drawable.tohoai,
            R.drawable.canthiep,
            R.drawable.cattuong,
            R.drawable.danhlua,
            R.drawable.tichphan,
            R.drawable.quyhang,
            R.drawable.giangmai,
            R.drawable.giandiep,
            R.drawable.songsong,
            R.drawable.thothe,
            R.drawable.thattinh,
            R.drawable.tranhthu,
            R.drawable.totien,
            R.drawable.masat,
            R.drawable.hongtam,
            R.drawable.baola,
            R.drawable.kinhdo,
            R.drawable.hungthu,
            R.drawable.tinhtruong,
            R.drawable.baoquat,
            R.drawable.caumay,
            R.drawable.nhaccu,
            R.drawable.noithat,
            R.drawable.dauthu,
            R.drawable.nemdadautay,
            R.drawable.baophu,
            R.drawable.langthang,
            R.drawable.chidiem,
            R.drawable.congtrai,
            R.drawable.badong,
            R.drawable.thankhoc,
            R.drawable.aimo,
            R.drawable.thongtan,
            R.drawable.baotu,
            R.drawable.muinhon,
            R.drawable.luclac,
            R.drawable.thoo,
            R.drawable.nhahat,
            R.drawable.baothuc,
            R.drawable.bongda,
            R.drawable.bactinh,
            R.drawable.hailong,
            R.drawable.bioi,
            R.drawable.ngangu,
            R.drawable.binhhoadidong,
            R.drawable.dongcamcongkho,
            R.drawable.traumong,
            R.drawable.nguao,
            R.drawable.baxa,
            R.drawable.xehoa,
            R.drawable.cobap,
            R.drawable.xuongrong,
            R.drawable.hanhha,
            R.drawable.detien,
            R.drawable.nhanduc,
            R.drawable.taihoa,
            R.drawable.chantuong,
            R.drawable.bamoi,
            R.drawable.congbo,
            R.drawable.binhchannhuvai,
            R.drawable.khoanhong,
            R.drawable.hamhau,
            R.drawable.hinhbinhhanh,
            R.drawable.matkhau,
            R.drawable.tangca,
            R.drawable.thichthu,
            R.drawable.nhantu,
            R.drawable.baodong,
            R.drawable.keoculuaxe,
            R.drawable.caokien,
            R.drawable.quycu,
            R.drawable.nanglong,
            R.drawable.candauvan,
            R.drawable.mahoa,
            R.drawable.macarong,
            R.drawable.cohoi,
            R.drawable.thamhoa,
            R.drawable.matuy,
            R.drawable.tungtang,
            R.drawable.ruatien,
            R.drawable.binhyen,
            R.drawable.xalan,
            R.drawable.vuonbachthu,
            R.drawable.nhagiao,
            R.drawable.moitruong,
            R.drawable.manocanh,
            R.drawable.tiendao,
            R.drawable.baongu,
            R.drawable.dinhcong,
            R.drawable.anmay,
            R.drawable.thachcao,
            R.drawable.xedieu,
            R.drawable.hoangthat,

    };
    private Random random=new Random();
    private String ketQua = "";
    private Button[] btnKq;
    private int rd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rd = random();
        initText();
        creatButton();
        creatImage();
        creatButtonPick();
    }
    public void creatButtonChoose(){
        btnChoose=new Button(this);
        layout_button= (LinearLayout) findViewById(R.id.layout_buton);
        btnChoose.setLayoutParams(new LinearLayout.LayoutParams(250,90));
        btnChoose.setBackgroundResource(R.drawable.next);
        btnChoose.setOnClickListener(this);
        btnChoose.setId(100);
        layout_button.addView(btnChoose);
    }
    public int random(){
        ArrayList<Integer> arrRD=new ArrayList<>();
        int rdNumber=0;
        while (check(arrRD, rdNumber)) {
            rdNumber= random.nextInt(QUESTIONS.length);
            arrRD.add(rdNumber);
        }
        return rdNumber;
    }

    public void initText() {
        txt_coin = (TextView) findViewById(R.id.txt_coin);
        txt_heart = (TextView) findViewById(R.id.txt_avatar);
        txt_ketQua= (TextView) findViewById(R.id.txt_ketQua);
    }

    public void creatImage() {
        layout_2 = (LinearLayout) findViewById(R.id.layout_2);
        ImageView []iv = new ImageView[QUESTIONS.length];
        iv[rd]=new ImageView(this);
        iv[rd].setImageResource(QUESTIONS[rd]);
        layout_2.addView(iv[rd]);
    }

    public void creatButton() {
        layout_3 = (LinearLayout) findViewById(R.id.layout_3);
        btnKq= new Button[DAP_AN[rd].length()];
        for (int i = 0; i < DAP_AN[rd].length(); i++) {
            Button btn = new Button(this);
            btn.setLayoutParams(new LinearLayout.LayoutParams(80,90));
            btn.setId(i);
            btn.setBackgroundResource(R.drawable.button_xam);
            layout_3.addView(btn);
            btnKq[i] = (Button) findViewById(btn.getId());
        }
    }
    public ArrayList randomQuestions(){
        ArrayList<String> arrS =new ArrayList<>();
        int tm=random.nextInt(25)+65;
        for (int i=0;i<DAP_AN[rd].length();i++){
            arrS.add(DAP_AN[rd].charAt(i)+"");
        }
        for (int i=0;i<16-DAP_AN[rd].length();i++){
            arrS.add((char)tm+"");
        }
        return arrS;
    }
    public boolean check(ArrayList<Integer> arrSo,int n){
        for (int i=0;i<arrSo.size();i++){
            if (n==arrSo.get(i)){
                return false;
            }
        }
        return true;
    }

    public void creatButtonPick(){
        layout_4= (LinearLayout) findViewById(R.id.layout_4);
        layout_5= (LinearLayout) findViewById(R.id.layout_5);
        ArrayList<Integer> arrSo=new ArrayList<>();
        for (int i=0;i<8;i++){
            Button btn= new Button(this);
            btn.setLayoutParams(new LinearLayout.LayoutParams(90,120));
            btn.setBackgroundResource(R.drawable.tile_hover);
            btn.setOnClickListener(this);
            while (btn.getText()=="") {
                int tmp=random.nextInt(16);
                if (check(arrSo, tmp)) {
                    btn.setText((CharSequence) randomQuestions().get(tmp));
                    randomQuestions().remove(tmp);
                    arrSo.add(tmp);
                }
            }
            layout_4.addView(btn);
        }
        for (int i=0;i<8;i++){
            Button btn= new Button(this);
            btn.setLayoutParams(new LinearLayout.LayoutParams(90,120));
            btn.setBackgroundResource(R.drawable.tile_hover);
            btn.setOnClickListener(this);
            while (btn.getText()=="") {
                int tmp=random.nextInt(16);
                if (check(arrSo, tmp)) {
                    btn.setText((CharSequence) randomQuestions().get(tmp));
                    randomQuestions().remove(tmp);
                    arrSo.add(tmp);
                }
            }
            layout_5.addView(btn);
        }
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        if (dem == DAP_AN[rd].length()) {
            if (ketQua.equals(DAP_AN[rd])) {
                for (int i = 0; i < DAP_AN[rd].length(); i++) {
                    btnKq[i].setBackgroundResource(R.drawable.tile_true);
                }
                txt_ketQua.setText("Bạn đã trả lời đúng !!!");
                creatButtonChoose();
                btnChoose.setText("NEXT");
                layout_button.setVisibility(View.VISIBLE);
                switch (v.getId()){
                    case 100:
                        coin += 100;
                        txt_coin.setText(coin + "");
                        layout_4.removeAllViews();
                        layout_5.removeAllViews();
                        layout_3.removeAllViews();
                        layout_2.removeAllViews();
                        layout_button.removeAllViews();
                        rd = random();
                        creatButtonPick();
                        creatImage();
                        creatButton();
                        txt_ketQua.setText("");
                        ketQua="";
                        dem=0;
                        i=0;
                        break;
                }
                return;
            } else {
                for (int i = 0; i < DAP_AN[rd].length(); i++) {
                    btnKq[i].setBackgroundResource(R.drawable.tile_false);
                }
                txt_ketQua.setText("Bạn đã trả lời sai !!!");
                creatButtonChoose();
                btnChoose.setText("AGAIN");
                layout_button.setVisibility(View.VISIBLE);
                switch (v.getId()){
                    case 100:
                        heart -= 1;
                        txt_heart.setText(heart + "");
                        layout_4.removeAllViews();
                        layout_5.removeAllViews();
                        layout_3.removeAllViews();
                        layout_2.removeAllViews();
                        layout_button.removeAllViews();
                        creatButtonPick();
                        creatImage();
                        creatButton();
                        txt_ketQua.setText("");
                        ketQua="";
                        dem=0;
                        i=0;
                        break;
                }
                return;
            }
        }if (heart==0){
            Toast.makeText(this,"Bạn đã thua",Toast.LENGTH_SHORT).show();
            return;
        }
        btnKq[i].setText(button.getText());
        ketQua += button.getText();
        i++;
        v.setEnabled(false);
        v.setBackgroundColor(601800);
        ((Button) v).setText("");
        dem++;
    }
}
