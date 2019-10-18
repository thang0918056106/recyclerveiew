package thangvo.vvt.apptrasua;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<TraSua> traSuaArrayList;
    TraSuaAdapter traSuaAdapter;
    Button btnThem , btnThoat,btnCapNhatupdate,btnThoatUpdate;
    EditText edtTen,edtChiTiet,edtGia;
    ImageView imgHinhDialog;
    int vitri = -1;
    int temp = -1;
    TraSua traSua;
    TextView txtTieude1;
    EditText edtTen1;
    EditText edtChitiet1;
    EditText edtGia1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


    }


    private void init(){
        recyclerView = (RecyclerView)findViewById(R.id.recyclerviewMain);
        recyclerView.setHasFixedSize(true);
        traSuaArrayList = new ArrayList<>();
        traSuaArrayList.add(new TraSua(R.drawable.trasua1,"Trà đào chanh sả","Hương vị thơm ngon đậm đà!","32.000d"));
        traSuaArrayList.add(new TraSua(R.drawable.trausuatranchauduongden,"Trà sữa trân châu đường đen","Hương vị béo và thơm nồng mùi sữa!","35.000d"));
        traSuaArrayList.add(new TraSua(R.drawable.trasuaxanhthachphomai,"Trà sữa xanh thạch phô mai","Hương vị béo và thơm nồng mùi sữa!","35.000d"));
        traSuaArrayList.add(new TraSua(R.drawable.cachitea,"CACHI TEA","Ngon đậm đà , đậm chất riêng","44.000d"));
        traSuaArrayList.add(new TraSua(R.drawable.trasuacaphe,"Trà sữa cà phê","Uống là mê ngay , hương cà phê trung nguyên","52.000d"));
        traSuaArrayList.add(new TraSua(R.drawable.caphe,"COFFEE","Uống là nghiện , nghiện là có!","28.000d"));
        traSuaArrayList.add(new TraSua(R.drawable.trasua2,"Trà sữa nhà làm","Hương vị như ở nhà!","30.000d"));
        traSuaAdapter = new TraSuaAdapter(traSuaArrayList,MainActivity.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(traSuaAdapter);

        ((TraSuaAdapter)recyclerView.getAdapter()).setItemClicklistener(new ItemClicklistener() {
            @Override
            public void onClick(View v, int positon) {
                traSua = (traSuaArrayList.get(positon));
                DialogUpdate();
                edtChitiet1.setText(traSua.getChitet());
                edtTen1.setText(traSua.getTen());
                edtGia1.setText(traSua.getGia());




            }

            @Override
            public void onLongClick(View v, int position) {
                Remove(position);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void Remove(final int position){
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Thông Báo");
        alertDialog.setMessage("Bạn có muốn xoá không?");
        alertDialog.setNegativeButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                traSuaArrayList.remove(position);
                traSuaAdapter.notifyDataSetChanged();

            }
        });
        alertDialog.setPositiveButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        alertDialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu : DialogAdd();
            break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void DialogAdd(){

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog);
        imgHinhDialog = (ImageView)dialog.findViewById(R.id.imgHinhDialog) ;
        btnThem = (Button) dialog.findViewById(R.id.btnThemDialog);
        btnThoat = (Button)dialog.findViewById(R.id.btnThoatDialog);
        edtTen = (EditText)dialog.findViewById(R.id.edtTendialog);
        edtChiTiet = (EditText)dialog.findViewById(R.id.edtChitietDialog);
        edtGia = (EditText)dialog.findViewById(R.id.edtGiaDialog);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = edtTen.getText().toString();
                String chitiet = edtChiTiet.getText().toString();
                String gia = edtGia.getText().toString();
                traSuaArrayList.add(new TraSua(R.drawable.caphe,ten,chitiet,gia));
                traSuaAdapter.notifyDataSetChanged();
                dialog.cancel();
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });

        dialog.show();
    }

    public void DialogUpdate(){
        temp = -1;
        final Dialog dialogupdate = new Dialog(this);
        dialogupdate.setContentView(R.layout.dialogupdate);
        btnCapNhatupdate = (Button)dialogupdate.findViewById(R.id.btnCapNhatupdate);
        btnThoatUpdate =(Button)dialogupdate.findViewById(R.id.btnThoatCapNhatupdate);
         txtTieude1 = (TextView)dialogupdate.findViewById(R.id.txtTieudedialog1);
         edtTen1 = (EditText)dialogupdate.findViewById(R.id.edtTendialog1);
         edtChitiet1 = (EditText)dialogupdate.findViewById(R.id.edtChitietDialog1);
         edtGia1 = (EditText)dialogupdate.findViewById(R.id.edtGiaDialog1);

        btnCapNhatupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp = 0;
                traSua.setChitet(edtChitiet1.getText().toString());
                traSua.setGia(edtGia1.getText().toString());
                traSua.setTen(edtTen1.getText().toString());
                traSuaAdapter.notifyDataSetChanged();
                dialogupdate.cancel();
            }
        });
        btnThoatUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogupdate.dismiss();
            }
        });
        dialogupdate.show();

    }
}
