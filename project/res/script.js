$(document).ready(function() {
  $(window).resize(function() {
    resizeGwt();
  });
});
$(window).on('load', function() {
  resizeGwt();
});

function resizeGwt() {
  $("#gwt").css("width", "100%");
  $("#gwt").css("height", $(window).height()-66-12);
}
