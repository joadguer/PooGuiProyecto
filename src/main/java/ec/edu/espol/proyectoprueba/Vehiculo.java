/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectoprueba;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author JOSUE
 */
public class Vehiculo {
        protected String placa;
        protected String marca;
        protected String modelo;
        protected String tipoMotor;
        protected String color;
        protected String tipoCombustible;
        protected int año;
        protected int recorrido;
        protected double precio;
        private int idVehiculo;
        protected  static ArrayList<Oferta> ofertas;
        protected static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    
    public Vehiculo(int idVehiculo, String placa, String marca, String modelo, String tipoMotor, String color, String tipoCombustible, int año, int recorrido, double precio) {
        this.idVehiculo = idVehiculo;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipoMotor = tipoMotor;
        this.color = color;
        this.tipoCombustible = tipoCombustible;
        this.año = año;
        this.recorrido = recorrido;
        this.precio = precio;
        this.ofertas = new ArrayList<>();
    }



    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(int recorrido) {
        this.recorrido = recorrido;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public static ArrayList<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(ArrayList<Oferta> ofertas) {
        this.ofertas = ofertas;
    }

    public static ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public static void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        Vehiculo.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", tipoMotor=" + tipoMotor + ", color=" + color + ", tipoCombustible=" + tipoCombustible + ", a\u00f1o=" + año + ", recorrido=" + recorrido + ", precio=" + precio + ", idVehiculo=" + idVehiculo + ", ofertas=" + ofertas + '}';
    }
    
    public void saveFile(String nameFile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nameFile),true))){
            pw.println(this.idVehiculo+"-"+this.placa+"-"+this.marca+"-"+this.modelo+"-"+this.tipoMotor+"-"+this.color+"-"+this.tipoCombustible+"-"+this.año+"-"+this.recorrido+"-"+this.precio);
            Vehiculo.vehiculos.add(this); 
        }catch(Exception e){
            System.out.println(e.getMessage());
        }	
        }
    
    public static void saveFile(ArrayList<Vehiculo> vehiculos, String nameFile){
	try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nameFile), true ))){
            for(Vehiculo v: vehiculos){
                pw.println(v.idVehiculo+"-"+v.placa+"-"+v.marca+"-"+v.modelo+"-"+v.tipoMotor+"-"+v.color+"-"+v.tipoCombustible+"-"+v.año+"-"+v.recorrido+"-"+v.precio);
                Vehiculo.vehiculos.add(v); 
        }
        }catch(Exception e){
            System.out.println(e.getMessage());    
        }	
    }
    
    
    public static void saveFile(ArrayList<Vehiculo> vehiculos, String nameFile,boolean append){
	try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nameFile), append ))){
            for(Vehiculo v: vehiculos){
                pw.println(v.idVehiculo+"-"+v.placa+"-"+v.marca+"-"+v.modelo+"-"+v.tipoMotor+"-"+v.color+"-"+v.tipoCombustible+"-"+v.año+"-"+v.recorrido+"-"+v.precio);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());    
        }	
    }    
    
    public static ArrayList<Vehiculo> readFile(String nameFile){
	ArrayList<Vehiculo> vehiculos = new ArrayList<>();
	try(Scanner sc = new Scanner(new File(nameFile))){
            while(sc.hasNextLine()){
                String linea  = sc.nextLine();
                String[] ven = linea.split("-");
                Vehiculo va = new Vehiculo(Integer.parseInt(ven[0]),ven[1],ven[2],ven[3],ven[4],ven[5],ven[6],Integer.parseInt(ven[7]),Integer.parseInt(ven[8]), Double.parseDouble(ven[9]));
                
                vehiculos.add(va);
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }	
        return vehiculos;
    }
        
    public void addOferta(Oferta e){
        this.ofertas.add(e);
    }        
}
