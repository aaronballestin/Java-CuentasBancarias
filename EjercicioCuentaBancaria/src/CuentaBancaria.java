import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CuentaBancaria{
    private String _strtitularCuenta;
    private String _strIBAN;
    private double _dblsaldo = 0;
    private ArrayList<Double> movimientos = new ArrayList<Double>();

    public CuentaBancaria(String p_strtitularCuenta, String p_strIBAN){
        setTitularCuenta(p_strtitularCuenta);
        setIBAN(p_strIBAN);
    }

    public void setTitularCuenta(String p_strTitularCuenta){
       if(titularCorrecto(p_strTitularCuenta)){
        _strtitularCuenta = p_strTitularCuenta;
       }
    }

    public String getTitularCuenta(){
        return _strtitularCuenta;
    }

    public void setIBAN(String p_strIBAN){
        if(IBANCorrecto(p_strIBAN)){
            _strIBAN = p_strIBAN;
        }
    }

    public String getIBAN(){
        return _strIBAN;
    }

    public double getSaldo(){
        return _dblsaldo;
    }

    public ArrayList getMovimientos(){
        return movimientos;
    }

    public String toString(){
        return "Titular de la cuenta "+getTitularCuenta()+" IBAN "+getIBAN()+" Saldo: "+_dblsaldo;
    }

    private void añadirMovimientos(double p_doubleMovimientos){
        if(movimientos.size() == 99){
            movimientos.remove(0);
            movimientos.add(p_doubleMovimientos);
        }else{
            movimientos.add(p_doubleMovimientos);
        }
    }

    public void modificarSaldo(Double p_dblDinero){
        if( p_dblDinero + _dblsaldo< 0 ){//esto es para cuando se quiere retirar dinero y se quiere retirar mas del que tienes
            System.out.println("No tienes suficiente dinero");
        }else{
            _dblsaldo += p_dblDinero;
            añadirMovimientos(p_dblDinero);;
        }
    }

    // private boolean IBANValido(String p_strIBAN){
    //     boolean bRet = true;
    //     int contadorLetras = 2;
    //     if(esLetra(p_strIBAN.charAt(0)) && esLetra(p_strIBAN.charAt(1)) && p_strIBAN.length() == 24){
    //         while(bRet && contadorLetras<24){
    //             if(!esNumero(p_strIBAN.charAt(contadorLetras))){
    //                 bRet = false;
    //             }else{
    //                 contadorLetras ++;
    //             }
    //         }
    //     }else{
    //         bRet = false;
    //     }
    //     return bRet;
    // }
    /*
     * Metodo que comprueba y devuelve si el IBAN es corecto utilizando Regex
     */
    private boolean IBANCorrecto(String p_strIBAN){
        boolean bRet = true;
        //con el comando de abajo comprueba si las dos primeras son letras mayusculas y si luego hay 22 numeros
        Pattern pattern = Pattern.compile("^([A-Z]{2})([0-9]{22})$");
        Matcher matcher = pattern.matcher(p_strIBAN);
        if(matcher.matches()){

        }else{
            bRet = false;
        }
        return bRet;
    }

    // private boolean titularValido(String p_strTitular){
    //     boolean bRet = true;
    //     int contadorCaracteres = 0;
    //     if(p_strTitular.length() > 0){
    //         while(bRet && contadorCaracteres < p_strTitular.length()){
    //             if(!(esLetra(p_strTitular.charAt(contadorCaracteres)) || esLetraMinuscula(p_strTitular.charAt(contadorCaracteres)) || p_strTitular.charAt(contadorCaracteres) == ' ' )){
    //                 bRet = false;
    //             }else{
    //                 contadorCaracteres++;
    //             }
    //         }
    //     }else{
    //         bRet = false;
    //     }
        
    //     return bRet;
    // }
        /*
         * Función que comprueba y devuelve si el titular de la cuenta es valido.
         * Para esto tendra que cuenta que se utilicen letras mayusculas o minusculas(no se pueden utilizar numeros ni caracteres especiales, pero sí acentos)
         * Minimo el titular tendrá que estar compuesto por un nombre y un apellido y no tiene limite de palabras
         */
    private boolean titularCorrecto(String p_strTitular) {
        boolean bRet = true;
        Pattern pattern = Pattern.compile("^\\s?[A-Za-zÁ-ÿ]+[A-Za-zÁ-ÿ]+([\\s][A-Za-zÁ-ÿ]+)*$"); 
        Matcher matcher = pattern.matcher(p_strTitular);
        if (matcher.matches()) {
            
        } else {
            bRet = false;
        }
        return bRet;
    }

    // private boolean esNumero(char p_cNumero){
    //     return p_cNumero >= '0' && p_cNumero <='9';
    // }

    // private boolean esLetra(char p_cLetra){
    //     return p_cLetra >= 'A' && p_cLetra <='Z';
    // }

    // private boolean esLetraMinuscula(char p_cLetra){
    //     return p_cLetra >='a' && p_cLetra <= 'z';
    // }

   
}