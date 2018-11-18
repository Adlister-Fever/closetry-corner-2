//grab all category names on screen.
    var cats = $('span').children();

//grab user search input and store in variable
    var catSelection = document.querySelector('#search-selection');



    function searchCats() {

        var selectedCat = catSelection.value;


        if(selectedCat.toString() != ""){
            $('.garment-card').hide();
        } else {
            $('.garment-card').show();

        }


        for (var i = 0; i <= cats.length - 1; i++) {
            if (cats[i].innerText.toLowerCase().indexOf(selectedCat.toLowerCase()) > -1 &&
                cats[i].innerText.toLowerCase().charAt(0) === selectedCat.toLowerCase().charAt(0)) {


                var elem = $(cats[i]).parent().parent().parent().get(0);
                $(elem).show();
            }
        }
    }



