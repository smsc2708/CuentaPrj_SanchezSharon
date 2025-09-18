import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cuenta {
    private String codCuenta = "cta-";
    private double saldo;
    private String nombreCuentaHabiente;
    private String fechaCreacion;
    private int cantDepositosRealizados;
    private int cantRetirosExitososRealizados;
    private static int cantCuentasCreada = 0;
    
    public Cuenta(String nombreCuentaHabiente, double pSaldo){
        cantCuentasCreada++;
        this.codCuenta += cantCuentasCreada;
        this.nombreCuentaHabiente = nombreCuentaHabiente;
        this.saldo = pSaldo;
        this.fechaCreacion = obtenerFecha();
    }
    
    public Cuenta(double pSaldo){
        cantCuentasCreada++;
        this.codCuenta += cantCuentasCreada;
        this.saldo = pSaldo;
        this.fechaCreacion = obtenerFecha();
    }
    
    private String obtenerFecha(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formato);
    }
    
    public void setNombreCuentaHabiente(String pNombreCuentaHabiente) {
        this.nombreCuentaHabiente = pNombreCuentaHabiente;
    }
    
    public String getCodCuenta (){
        return codCuenta;
    }
    
    public double getSaldo() {
        return saldo;
    }

    public static int getCantCuentasCreada() {
        return cantCuentasCreada;
    }
    
    public double depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            cantDepositosRealizados++;
        }
        return saldo;
    }

    public double retirar(double monto) {
        if (validarRetiro(monto)) {
            saldo -= monto;
            cantRetirosExitososRealizados++;
        }
        return saldo;
    }

    public boolean validarRetiro(double monto) {
        return monto > 0 && monto <= saldo;
    }
    
    @Override
    public String toString() {
        return "Cuenta{" +
                "codCuenta='" + codCuenta + '\'' +
                ", saldo=" + saldo +
                ", nombreCuentaHabiente='" + nombreCuentaHabiente + '\'' +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                ", cantDepositosRealizados=" + cantDepositosRealizados +
                ", cantRetirosExitososRealizados=" + cantRetirosExitososRealizados +
                ", cantCuentasCreadas=" + cantCuentasCreada +
                '}';
    }
}