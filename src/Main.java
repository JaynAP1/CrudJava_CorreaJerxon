import org.json.JSONArray;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    int id;
    int Cantidad;
    String Nombre;
    float PrecioTotal;
    float PrecioUnitario;

    public Main(int id, int Cantidad, String Nombre, float PrecioTotal, float PrecioUnitario) {
        this.id = id;
        this.Cantidad = Cantidad;
        this.Nombre = Nombre;
        this.PrecioTotal = PrecioTotal;
        this.PrecioUnitario = PrecioUnitario;
    }
    @Override
    public String toString() {
        return "{id:" + id + ", cantidad:" + Cantidad + ", nombre:" + Nombre + ", precio:" + PrecioTotal + ", precioUnitario:" + PrecioUnitario + "}";
    }


    public static void main(String[] args) {

        try{
            URL url = new URL("https://66fe4aa42b9aac9c997b3402.mockapi.io/Feria/Matematicas");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int code = conn.getResponseCode();
            if(code != 200){
                throw new RuntimeException("Ocurrio un error al obtener el servidor: " + code);
            } else {
                StringBuilder information = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while(scanner.hasNext()){
                    information.append(scanner.nextLine());
                }

                scanner.close();

                JSONArray array = new JSONArray(information.toString());
                JSONObject objP = array.getJSONObject(0);

                JSONArray PansitoArray = (JSONArray) objP.get("productos");

                ArrayList<Main> Carrito = new ArrayList<>();

                boolean booleanito = true;

                while (booleanito) {
                    System.out.print("""
                    =============================================\

                    1).Añadir al carrito.\

                    2).Cancelar los productos del carrito.\

                    3).Actualizar carrito.\
                    
                    4).Ver carrito.\

                    5).Salir.

                    =============================================""");

                    Scanner Enter = new Scanner(System.in);
                    Scanner Select = new Scanner(System.in);
                    System.out.print("\nIngrese con un numero la opcion deseada.");

                    String MenuInput = Select.nextLine();

                    if (MenuInput.equals("1")) {
                        System.out.print("""
                                =============================================\

                                1).Panes.\

                                =============================================""");

                        Scanner SelectC1 = new Scanner(System.in);
                        System.out.print("\nIngrese con un numero la opcion deseada.");
                        String MenuInputC1 = SelectC1.nextLine();

                        if (MenuInputC1.equals("1")) {
                            for(Object Pansitos :PansitoArray){
                                JSONObject Pansito = (JSONObject) Pansitos;
                                System.out.println(Pansito.getString("id") +")." + Pansito.getString("nombre") + " Precio: " + Pansito.getFloat("precio"));
                            };

                            Scanner SelectPan = new Scanner(System.in);
                            System.out.print("\nIngrese con un numero la opcion deseada.");
                            int PanSelect  =  SelectPan.nextInt();

                            Scanner SelectCan = new Scanner(System.in);
                            System.out.println("Ingrese la cantidad deseada.");
                            int CanSelect =  SelectCan.nextInt();

                            for (int i = 0; i <= (PanSelect - 1) ; i++) {

                                if (i == (PanSelect-1)) {
                                    JSONObject PanElegido = (JSONObject) PansitoArray.get(i);

                                    Carrito.add(new Main(
                                            PanElegido.getInt("id"),
                                            CanSelect,
                                            PanElegido.getString("nombre"),
                                            (PanElegido.getFloat("precio")*CanSelect),
                                            PanElegido.getFloat("precio")
                                    ));

                                    System.out.println("Has comprado "+ CanSelect + " unidades de "+ PanElegido.getString("nombre"));
                                }

                            }
                            String Enter1 = Enter.nextLine();

                        }
                    }
                    else if (MenuInput.equals("2")) {
                        if (Carrito.isEmpty()){
                            System.out.println("No hay objetos en el carrito");
                            String Enter1 = Enter.nextLine();
                        }
                        else {
                            System.out.println("=============================================");
                            JSONArray CarritoFull = new JSONArray(Carrito.toString());
                            int i = 0;
                            for (Object Mcarrito : CarritoFull) {
                                i++;

                                JSONObject CarritoMostrar = (JSONObject) Mcarrito;
                                System.out.println(i + ")." + CarritoMostrar.getString("nombre") + " Precio: " + CarritoMostrar.getFloat("precio"));
                            }
                            Scanner SelectElim = new Scanner(System.in);
                            System.out.println("Escriba el numero del pedido que desea eliminar");
                            int Eliminar = SelectElim.nextInt();

                            Carrito.remove(Eliminar - 1);
                            System.out.println("Objeto eliminado con exito");
                        }

                    } else if (MenuInput.equals("3")) {
                        if (Carrito.isEmpty()){
                            System.out.println("No hay objetos en el carrito");
                            String Enter1 = Enter.nextLine();
                        }
                        else {
                            System.out.println("=============================================");
                            JSONArray CarritoFull = new JSONArray(Carrito.toString());
                            int i = 0;
                            for (Object Mcarrito : CarritoFull) {
                                i++;

                                JSONObject CarritoMostrar = (JSONObject) Mcarrito;
                                System.out.println(i + ")." + CarritoMostrar.getString("nombre") + " Precio: " + CarritoMostrar.getFloat("precio"));
                            }
                            Scanner SelectElim = new Scanner(System.in);
                            System.out.println("Escriba el numero del pedido que desea Actualizar");
                            int Eliminate = SelectElim.nextInt();
                            Scanner SelectCan = new Scanner(System.in);
                            System.out.println("Que cantidad desea llevar ahora?");
                            int CanSelect = SelectCan.nextInt();

                            JSONArray CarritoActua = new JSONArray(Carrito.toString());
                            JSONObject UpdateCar = CarritoActua.getJSONObject(Eliminate-1);
                            System.out.println(UpdateCar);
                            Carrito.remove(Eliminate - 1);
                            Carrito.add(new Main(
                                    UpdateCar.getInt("id"),
                                    CanSelect,
                                    UpdateCar.getString("nombre"),
                                    (UpdateCar.getFloat("precioUnitario")*CanSelect),
                                    UpdateCar.getFloat("precioUnitario")
                            ));

                            System.out.println("Objeto Actualizado con exito");
                        }

                    } else if (MenuInput.equals("4")) {
                        if (Carrito.isEmpty()){
                            System.out.println("No hay objetos en el carrito");
                            String Enter1 = Enter.nextLine();
                        }
                        else {
                            System.out.println("=============================================");
                            JSONArray CarritoFull = new JSONArray(Carrito.toString());
                            int i = 0;
                            for (Object Mcarrito : CarritoFull) {
                                i++;

                                JSONObject CarritoMostrar = (JSONObject) Mcarrito;
                                System.out.println(i+")."+CarritoMostrar.getString("nombre") + " Precio: " + CarritoMostrar.getFloat("precio"));
                            }
                        }
                    } else {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}