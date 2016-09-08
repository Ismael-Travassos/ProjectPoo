package com.example.els.fasttruck;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by El's on 08/09/2016.
 */
public class CadastrarIng extends Activity {
    final public Ingrediente ingrediente = new Ingrediente();
    final public static String cadIng = "CADASTROING";
    private EditText nome;
    private int status = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar_ing_layout);
        nome = (EditText)findViewById(R.id.nome_ingrediente);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onRadioButtonClicked(View view) {
        // Obtem o botao q esta ativo
        boolean checked = ((RadioButton) view).isChecked();

        // Verifica qual botão foi pego, pelo id
        switch(view.getId()) {
            case R.id.Tem:
                if (checked)
                    // Altera o status do ingrediente para 1/tem;
                    status = 1;
                break;
            case R.id.NaoTem:
                if (checked)
                    // Altera o status do ingrediente para 0/não tem;
                    status = 0;
                break;
        }
    }
    public  void clickSalvar(View view){

        if(nome.getText().toString().isEmpty())
            Toast.makeText(CadastrarIng.this, "Informe o ingrediente!", Toast.LENGTH_LONG).show();
        else
        {
            ingrediente.setStatus(status);
            ingrediente.setNome((String)nome.getText().toString());
            // Devemos ver a questão da persistencia.
            // Aqui deve ficar a chamada referente ao armazena do ingrediente.

            Toast.makeText(CadastrarIng.this, ingrediente.getNome()+" cadastrado!", Toast.LENGTH_LONG).show();
        }
    }

}
