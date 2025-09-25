package com.surtimax.gestor_inventario.service;

import com.surtimax.gestor_inventario.entity.*;
import com.surtimax.gestor_inventario.repository.*;
import org.hibernate.mapping.Array;
import org.hibernate.mapping.KeyValue;
import org.hibernate.mapping.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import static org.apache.coyote.http11.Constants.a;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private ProductoRepository productosRepository;
    @Autowired
    private CosmeticosRepository cosmeticosRepository;
    @Autowired
    private LacteosRepository lacteosRepository;
    @Autowired
    private FrutasRepository frutasRepository;
    @Autowired
    private PanaderiaRepository panaderiaRepository;
    @Autowired
    private VerdurasRepository verdurasRepository;
    @Autowired
    private FarmaciaRepository farmaciaRepository;


    private List<Producto> listaProductos;
    private List<Cosmeticos> listaCosmeticos;
    private List<Farmacia> listaFarmacia;
    private List<Frutas> listaFrutas;
    private List<Lacteos> listaLacteos;
    private List<Verduras> listaVerduras;
    private List<Panaderia> listaPanaderia;

    public ProductoService(List<Producto> listaProductos, List<Cosmeticos> listaCosmeticos,
                           List<Farmacia> listaFarmacia, List<Frutas> listaFrutas,
                           List<Lacteos> listaLacteos, List<Panaderia> listaPanaderia, List<Verduras> listaVerduras) {
        this.listaProductos = listaProductos;
        this.listaFarmacia = listaFarmacia;
        this.listaFrutas = listaFrutas;
        this.listaLacteos = listaLacteos;
        this.listaPanaderia = listaPanaderia;
        this.listaVerduras = listaVerduras;
        this.listaCosmeticos = listaCosmeticos;
    }

    @Override
    public void agregarProductos() {

        Scanner teclado = new Scanner(System.in);
        Producto productos = new Producto();

        System.out.println("Digita el número 1 para ingresar un producto nuevo o cualquier otro para finalizar el programa");
        int input1 = teclado.nextInt();
        teclado.nextLine();

        while (input1 == 1){

            System.out.println("Ingresa el nombre del producto:");
            String inputTexto;
            inputTexto = teclado.nextLine();
            productos.setNombre(inputTexto);

            System.out.println("Ingresa la categoria del producto:");
            inputTexto = teclado.nextLine();
            productos.setCategoria(inputTexto);

            System.out.println("Ingresa la cantidad del producto:");
            int inputInt = teclado.nextInt();
            productos.setCantidad(inputInt);

            System.out.println("Ingresa el precio del producto:");
            double inputdouble = teclado.nextDouble();
            productos.setPrecio(inputdouble);

            listaProductos.add(new Producto(productos));
            listaProductos.forEach(System.out::println);
            productosRepository.saveAll(listaProductos);

            System.out.println("Digita 1 para agregar otro producto o el número 2 para finalizar");
            input1 = teclado.nextInt();
            teclado.nextLine();
        }
    }

    @Override
    public void organizarPorCategoria() {
        listaProductos = productosRepository.findAll();
        List<Cosmeticos> listaCosmeticosRepository = cosmeticosRepository.findAll();

        //Cosmeticos

        listaProductos.stream().filter(p -> p.getCategoria().contains("Cosmeticos"))
                .filter(p -> !Boolean.parseBoolean(cosmeticosRepository.existsByNombre(p.getNombre())))
                .forEach(p-> listaCosmeticos.add(new Cosmeticos(p)));
        cosmeticosRepository.saveAll(listaCosmeticos);

        //Farmacia

        listaProductos.stream().filter(p -> p.getCategoria().contains("Farmacia"))
                .filter(p -> !Boolean.parseBoolean(farmaciaRepository.existsByNombre(p.getNombre())))
                .forEach(p-> listaFarmacia.add(new Farmacia(p)));
        farmaciaRepository.saveAll(listaFarmacia);

        //Frutas

        listaProductos.stream().filter(p -> p.getCategoria().contains("Frutas"))
                .filter(p -> !Boolean.parseBoolean(frutasRepository.existsByNombre(p.getNombre())))
                .forEach(p-> listaFrutas.add(new Frutas(p)));
        frutasRepository.saveAll(listaFrutas);

        //Lacteos

        listaProductos.stream().filter(p -> p.getCategoria().contains("Lacteos"))
                .filter(p -> !Boolean.parseBoolean(lacteosRepository.existsByNombre(p.getNombre())))
                .forEach(p-> listaLacteos.add(new Lacteos(p)));
        lacteosRepository.saveAll(listaLacteos);

        //Panaderia

        listaProductos.stream().filter(p -> p.getCategoria().contains("Panaderia"))
                .filter(p -> !Boolean.parseBoolean(panaderiaRepository.existsByNombre(p.getNombre())))
                .forEach(p-> listaPanaderia.add(new Panaderia(p)));
        panaderiaRepository.saveAll(listaPanaderia);

        //Verdura

        listaProductos.stream().filter(p -> p.getCategoria().contains("Verdura"))
                .filter(p -> !Boolean.parseBoolean(verdurasRepository.existsByNombre(p.getNombre())))
                .forEach(p-> listaVerduras.add(new Verduras(p)));
        verdurasRepository.saveAll(listaVerduras);
    }

    @Override
    public void filtroFrutas() {
        listaProductos.stream().filter(p->p.getCategoria().contains("Frutas"))
                .forEach(System.out::println);
    }

    @Override
    public void filtroPrecioLacteos() {
        List<Double> listaTotalLacteos = new ArrayList<>();

        listaLacteos = lacteosRepository.findAll();
        double total = listaLacteos.stream().mapToDouble(l-> l.getPrecio() * l.getCantidad()).sum();

        System.out.println("El valor total de los productos relacionados a la categoria lacteos es: " +
                "$" + total + " pesos colombianos");
    }

    @Override
    public void filtroPrecioBajo() {
        listaProductos = productosRepository.findAll();
        OptionalDouble valorMinimo = listaProductos.stream().mapToDouble(Producto::getPrecio).min();
        List<String> nombre = listaProductos.stream()
                .map(p->p.getPrecio() == valorMinimo.getAsDouble() ? p.getNombre()
                + " es el producto con el valor mas bajo, con un precio de : " + valorMinimo.getAsDouble() : "Sin datos encontrados")
                .filter(p->!p.contains("Sin datos encontrados")).toList();
        System.out.println(nombre.get(0));
    }

    @Override
    public void calculoPromedioPorCategoria() {
        listaProductos = productosRepository.findAll();

        Map<String,Double> promedioPorCategoria = listaProductos.stream().parallel()
                .collect(Collectors.groupingBy(Producto::getCategoria,
                        Collectors.averagingDouble(Producto::getPrecio)));

        Double valorMaximo = Collections.max(promedioPorCategoria.values());
        List<String> listaEnunciado = new ArrayList<>();

        promedioPorCategoria.forEach((categoria,promedio)->
                        listaEnunciado.add(promedio == valorMaximo ?
                                "El valor promedio de la categoria " + categoria + " es: " + promedio : "No aplica"));

        System.out.println(listaEnunciado.stream().sorted().toList().get(0));
    }
}
