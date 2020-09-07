package com.farbal.ejercicio.ejerciciorecycleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Switch;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ModeloImagenes> modeloImagenes;
    private int layout;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout=R.layout.layout_imagenes;
           modeloImagenes=dataModelo();
           recyclerView=findViewById(R.id.recycler_view);
           layoutManager=new LinearLayoutManager(this);
       adapter=new Adapter(modeloImagenes, layout, new Adapter.onItemClickListener() {
           @Override
           public void onClick(int position) {
               borrar(position);
           }
       });
       recyclerView.setAdapter(adapter);
       recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();

        if (id==R.id.menu_agregar) {
            agregar(0);
            return true;
        }
        if (id==R.id.menu_borrar) {
            borrar(0);
            return true;
        }
        else {
            return super.onOptionsItemSelected(item);
        }


    }
    //crea en este metodo un array de tipo modelo para cargarlo en el array list modeloImagenes
    private ArrayList<ModeloImagenes> dataModelo() {
      return new ArrayList<ModeloImagenes>(){{
          add(new ModeloImagenes(R.drawable.imagen,"dd"));
          add(new ModeloImagenes(R.drawable.imagendos,"dd"));
          add(new ModeloImagenes(R.drawable.imagentres,"dd"));
          add(new ModeloImagenes(R.drawable.imagencuatro,"dd"));

      }

      };
    }
    //borra elemntos del recycler view
    private void  borrar(int posicion){
        modeloImagenes.remove(posicion);
        //hace que el adaptador sepa que se borro el elemento
        adapter.notifyItemRemoved(posicion);
        //sube la vista del recyclerView a la posicion deceada en este caso "posicion cero"
        layoutManager.scrollToPosition(posicion);


    }
    private void agregar(int posicion) {
        modeloImagenes.add(posicion,new ModeloImagenes(R.drawable.ic_launcher_background,"agregado"));
        adapter.notifyItemInserted(posicion);
        layoutManager.scrollToPosition(posicion);

    }
}