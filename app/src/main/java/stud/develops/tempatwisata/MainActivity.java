package stud.develops.tempatwisata;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvwisata;
    private ArrayList<TempatWisata> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvwisata = findViewById(R.id.wisata);
        rvwisata.setHasFixedSize(true);

        list.addAll(DataTempatWisata.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvwisata.setLayoutManager(new LinearLayoutManager(this));
        ListWisataAdapter listWisataAdapter = new ListWisataAdapter(list);
        rvwisata.setAdapter(listWisataAdapter);

        listWisataAdapter.setOnItemClickCallback(new ListWisataAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(TempatWisata data) {
                showSelectedWisata(data);
            }
        });
    }

    private void showSelectedWisata(TempatWisata tempatWisata) {
        Toast.makeText(this, "Kamu memilih " + tempatWisata.getNama(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,DataDetail.class);
        String[] data = {tempatWisata.getNama(),tempatWisata.getDetail(), String.valueOf(tempatWisata.getGambar())};
        intent.putExtra("data",data);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_profil) {
            startActivity(new Intent(MainActivity.this, About.class));
        }

        return true;
    }
}
