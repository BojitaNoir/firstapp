<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Usuarios</title>
  <jsp:include page="./layouts/head.jsp"/>
</head>
<body>
<div class="container-fluid">
  <div class="row">
    <div class="col text-center mt-5">
      <h2>Usuarios</h2>
      <p>Practica 1 Servlets para realizar un CRUD de usuarios</p>
      <div class="card">
        <div class="card-header">
          <div class="ca
          rd-body">
            <div class="col">Listado de Usuarios</div>
            <div class="col text-end" >
              <button class="btn btn-outline-success btn-sm">Agregar
              </button>
            </div>
          </div>
        </div>
        <div class="card-body">
          <table class="table table-stripped">
            <thead>
            <th>#</th>
            <th>Nombre</th>
            <th>fecha de nacimiento</th>
            <th>Usuario</th>
            <th>Estado</th>
            <th>Acciones</th>
            </thead>
            <tbody>
            <tr>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
            </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</div>
<jsp:include page="./layouts/footer.jsp"/>
</body>
</html>