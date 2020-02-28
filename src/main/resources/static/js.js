var visible = false;

$(".menu-toggle").click(function(e) {

    e.preventDefault();
    $("#wrapper").toggleClass("toggled");
    visible = !visible;
});

$("#page-body").click(function() {
    if (visible) {
        visible = false;
        $("#wrapper").toggleClass("toggled");
    }


});

$("#editarProducto").on("show.bs.modal", function (event) {
	var button = $(event.relatedTarget) // Button that triggered the modal
	var nombre = button.data("nombre") // Extract info from data-* attributes
	var id = button.data("id");
	var stock = button.data("stock");
	var prov = button.data("prov");
	alert(prov);
	// If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
	// Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
	var modal = $(this)
	modal.find(".modal-title").text("Editar Producto: " + nombre)
	modal.find(".modal-body #ID").val(id);
	modal.find(".modal-body #nombre").val(nombre);
	modal.find(".modal-body #stock").val(stock);
	
	});

	