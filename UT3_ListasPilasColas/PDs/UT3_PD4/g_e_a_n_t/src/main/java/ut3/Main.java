package ut3;

public class Main {

   public static void main(String[] args) {
       Almacen almacen = new Almacen("Almacen 1", "Calle 123", "123456789");
       Producto producto1 = new Producto(10001, "Producto 1", 1, 100);
       Producto producto2 = new Producto(1001, "Producto 2", 2, 200);
    Producto producto3 = new Producto(1112, "Producto 3", 3, 300);
    System.err.println("Direccion: " + almacen.getDireccion());
    System.err.println("Telefono: " + almacen.getTelefono());
    System.err.println("Nombre: " + almacen.getNombre());
    almacen.insertarProducto(producto1);
    almacen.insertarProducto(producto2);
    almacen.insertarProducto(producto3);
    almacen.listarOrdenadoPorNombre();
    System.err.println("Cantidad de productos: " + almacen.cantidadProductos());
    almacen.eliminarProducto(1000112);
    almacen.eliminarProducto(1000111);
    almacen.eliminarProducto(1000110);
    System.err.println("Compra total: $" + almacen.ingresarStock("C:\\Users\\MICAE\\OneDrive\\Escritorio\\Algorithmsn'DataStructures\\aed-2024-1-portafolio-micaelacrocco\\UT3\\UT3_PD4\\g_e_a_n_t\\src\\archivos almacen\\altas.txt"));
    System.err.println("Venta total: $" + almacen.ventaStock("C:\\Users\\MICAE\\OneDrive\\Escritorio\\Algorithmsn'DataStructures\\aed-2024-1-portafolio-micaelacrocco\\UT3\\UT3_PD4\\g_e_a_n_t\\src\\archivos almacen\\ventas.txt"));
    System.err.println("Valor de stock total: $" + almacen.obtenerValorStock());
   }

}