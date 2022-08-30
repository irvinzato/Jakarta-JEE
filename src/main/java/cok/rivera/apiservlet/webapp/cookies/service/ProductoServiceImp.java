package cok.rivera.apiservlet.webapp.cookies.service;

import cok.rivera.apiservlet.webapp.cookies.models.Producto;

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
