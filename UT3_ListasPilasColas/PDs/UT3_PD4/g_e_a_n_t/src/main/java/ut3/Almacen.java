package ut3;

public class Almacen implements IAlmacen {
    private Lista<IProducto> listaProductos;
    private String direccion;
    private String telefono;
    private String nombre;

    public Almacen(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.listaProductos = new Lista<>();
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Lista<IProducto> getListaProductos() {
        return this.listaProductos;
    }

    public void insertarProducto(IProducto unProducto) {
        this.listaProductos.insertar(unProducto.getEtiqueta(), unProducto);
    }

    public boolean eliminarProducto(Comparable clave) {
        return this.listaProductos.eliminar(clave);
    }

    public String imprimirProductos() {
        return this.listaProductos.imprimir();
    }

    public String imprimirSeparador(String separador) {
        return this.listaProductos.imprimir(separador);
    }

    public Boolean agregarStock(Comparable clave, Integer cantidad) {
        Nodo<IProducto> nodo = this.listaProductos.buscar(clave);
        if (nodo != null) {
            nodo.getDato().agregarCantidadStock(cantidad);
            return true;
        }
        return false;
    }

    public Integer restarStock (Comparable clave, Integer cantidad) {
        Nodo<IProducto> nodo = this.listaProductos.buscar(clave);
        if (nodo != null) {
            IProducto producto = nodo.getDato();
            if (producto.getStock() >= cantidad) {
                producto.restarCantidadStock(cantidad);
                return cantidad;
            } else {
                cantidad = producto.getStock();
                producto.restarCantidadStock(cantidad);
                return cantidad;
            }
        }
        return 0;
    }

    public IProducto buscarPorCodigo(Comparable clave) {
        Nodo<IProducto> nodo = this.listaProductos.buscar(clave);
        if (nodo != null) {
            return nodo.getDato();
        }
        return null;
    }

    // El array viene previamente creado y ordenado
    private Producto[] insertarArrayOrdenado(Producto[] array, Producto elemento, int next) {
        int i = 0;
        while (i < next && array[i].getNombre().compareTo(elemento.getNombre()) < 0) {
            i++;
        }
        if (i < next) {
            for (int j = next; j > i; j--) {
                array[j] = array[j - 1];
            }
        }
        array[i] = elemento;

        return array;
    }

    public void listarOrdenadoPorNombre() {
        String claves = listaProductos.imprimir(",");
        String[] clavesArray = claves.split(",");
        Producto[] productosOrdenados = new Producto[clavesArray.length];
        short next = 0;
        for (String clave : clavesArray) {
            IProducto producto = buscarPorCodigo(clave);
            productosOrdenados = insertarArrayOrdenado(productosOrdenados, (Producto) producto, next);
            next++;
        }
        for (Producto producto : productosOrdenados) {
            System.out.println("Nombre: " + producto.getNombre() + " | Stock: " + producto.getStock());
        }
    }

    public IProducto buscarPorDescripcion(String descripcion) {
        Nodo<IProducto> aux = this.listaProductos.getPrimero();
        while (aux != null) {
            if (aux.getDato().getNombre().equals(descripcion)) {
                return aux.getDato();
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    public int cantidadProductos() {
        return this.listaProductos.getCantElementos();
    }

    public Integer ingresarStock(String rutaArchivo) {
        Integer compraTotal = 0;
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(rutaArchivo);
        for (String linea : lineas) {
            String[] datos = linea.split(",");
            IProducto producto = buscarPorCodigo(Integer.parseInt(datos[0]));
            if (producto == null) {
                producto = new Producto(Integer.parseInt(datos[0]), datos[1], Integer.parseInt(datos[2]),
                        Integer.parseInt(datos[3]));
                this.insertarProducto(producto);
            } else {
                producto.agregarCantidadStock(Integer.parseInt(datos[3]));
            }
            compraTotal += Integer.parseInt(datos[2]) * Integer.parseInt(datos[3]);
        }
        return compraTotal;
    }

    public Integer ventaStock(String rutaArchivo) {
        Integer ventaTotal = 0;
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(rutaArchivo);
        for (String linea : lineas) {
            String[] datos = linea.split(",");
            IProducto prod = this.buscarPorCodigo(Integer.parseInt(datos[0]));
            if (prod != null) {
                prod.restarCantidadStock(Integer.parseInt(datos[1]));
                ventaTotal += prod.getPrecio() * Integer.parseInt(datos[1]);
            }
        }
        return ventaTotal;
    }

    // FALTA IMPLEMENTAR
    public long obtenerValorStock() {
        long valorTotal = 0;
        Nodo<IProducto> aux = this.listaProductos.getPrimero();
        while (aux != null) {
            valorTotal += aux.getDato().getPrecio() * aux.getDato().getStock();
            aux = aux.getSiguiente();
        }
        return valorTotal;
    }

}
