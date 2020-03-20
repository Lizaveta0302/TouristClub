$(document).ready(function() {
    $('#example').DataTable( {
        dom: 'Bfrtip',
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ]
    } );
    $('.dataTables_length').addClass('bs-select');

} );

var imgs = document.getElementsByClassName('img-fluid');

for (var i = 0; i < imgs.length; i++) {
    var num = Math.floor(Math.random() * 10 + 1);
    imgs[i].src = 'images/hike' + num + '.jpg';
    imgs[i].alt = imgs[i].src;
}