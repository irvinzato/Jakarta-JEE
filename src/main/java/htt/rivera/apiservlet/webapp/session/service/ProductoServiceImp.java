package htt.rivera.apiservlet.webapp.session.service;

import htt.rivera.apiservlet.webapp.session.models.Producto;

import java.util.Arrays;
import java.util.List;

public class ProductoServiceImp implements ProductoService {

  @Override
  public List<Producto> toList() {
    return Arrays.asList(new Producto(1L, "NoteBook", "Computación", 17500),
            new Producto(2L, "Yeyian CPU", "Computación", 15000),
            new Producto(3L, "Mesa Escritorio", "Oficina", 10000));
  }
}
