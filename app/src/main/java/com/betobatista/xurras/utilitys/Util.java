package com.betobatista.xurras.utilitys;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Adalberto on 01/10/15.
 */
public class Util {

    public static Context auxContext;

    // Auxiliar de Contexto //
    public static Context getAuxContext() {
        return auxContext;
    }

    public static void setAuxContext(Context auxContext) {
        Util.auxContext = auxContext;
    }

    // Data atual //
    public static String getDataHoje() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    // Data amanha //
    public static String getDataAmanha(){
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();

        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(tomorrow);
    }

    // Formata o a data //
    public static String setDataFormat(Date data) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(data);
    }

    // Edita a String para inserir na linha de codigo do sql //
    public static String setStrSql(String texto){
        return "'" + texto + "'";
    }

    // Formata o numero do lote //
    public static String getNrLote(String s) {
        return (s.substring(0,6) + "/" + s.substring(6, s.length()));
    }

    // Mensagem do tipo Toast //
    public static void exibirToast(String msg){
        Toast.makeText(getAuxContext(), msg, Toast.LENGTH_LONG).show();
    }

    // Mensagem do tipo Toast //
    public static void exibirToastRapido(String msg){
        Toast.makeText(getAuxContext(), msg, Toast.LENGTH_SHORT).show();
    }


    // Mensagem do tipo Dialog //
    public static void exibirMsgDialog(String msg, Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getAuxContext());
        builder.setCancelable(false);
        builder.setMessage(msg);
        builder.setNeutralButton("OK", null);
        builder.show();
    }

    // Formata os campos decimais //
    public static Double decimalValue(double value, int decimals){

        String decimalFormat = "#.";
        for(int i = 0; i < decimals; i++){
            decimalFormat = decimalFormat + "0";
        }

        DecimalFormat format = new DecimalFormat(decimalFormat);

        return Double.parseDouble(format.format(value).replace(",", "."));

    }





}
