const a = () => {
  var stamps = document.querySelectorAll(".stamp");

  for (var i = 0; i < stamps.length; i++) {
    var img = document.createElement("img");
    img.src = `/images/apple.png`;
    stamps[i].appendChild(img);
  }
};

a();
