package com.example.persistance.entity;


import jakarta.persistence.*;

@Entity//Anotación para crear la entidad
@Table(name = "productos")  //la anotación Table porque el nombre de la clase es distinto al de la tabla de la BD
public class Producto {

    @Id  //Indica que es la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //configura la forma de incremento de la columna
    @Column(name = "id_producto")  // Se le asignas el nombre correcto a la columna
    private Integer idProducto;

    private String nombre;  //Aquí no se cambia el nombre, porque esta igual en BD

    @Column(name = "id_categoria")  //aqui usamos la anotación column, porque se le cambia el nombre a la columna
    private Integer idCategoria;

  /*  @Column(name = "codigo_barras")
    private Integer codigoBarras;  */

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "cantidad_stock")
    private Integer cantidadStock;

    private Boolean estado;

    @ManyToOne  // crea una relación de muchos a uno con categorias, en otras palabras se mapea la llave foranea de id_categoria
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false) // atraves de esta relación , no se va a borrar, actualizar o insertar una nueva categoria
    private Categoria categoria;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

  /*  public Integer getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(Integer codigoBarras) {
        this.codigoBarras = codigoBarras;
    }
*/
    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
