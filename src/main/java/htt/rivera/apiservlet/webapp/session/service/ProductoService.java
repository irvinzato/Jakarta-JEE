package htt.rivera.apiservlet.webapp.session.service;

import htt.rivera.apiservlet.webapp.session.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
  List<Producto> toList();

  Optional<Producto> byId(Long id);
}
