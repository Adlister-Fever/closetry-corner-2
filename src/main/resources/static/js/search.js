//grab all category names on screen.
    var cats = $('span').children();

//grab user search input and store in variable
    var catSelection = document.querySelector('#search-selection');


    //loop through category names on screen and compare them to user search
    function searchCats() {
        //grab value from search bar
        var selectedCat = catSelection.value;

        //if search bar is empty i.e. user decides not to search after all,
        //show all the elements again.
        if(selectedCat.toString() != ""){
            $('.garment-card').hide();
        } else {
            $('.garment-card').show();

        }

        //comparison b/t search value and garments
        for (var i = 0; i <= cats.length - 1; i++) {
            // console.log(cats[i].innerText);
            // console.log(selectedCat);
            //if selectors match search terms
            if (cats[i].innerText.toLowerCase().indexOf(selectedCat.toLowerCase()) > -1 &&
                cats[i].innerText.toLowerCase().charAt(0) === selectedCat.toLowerCase().charAt(0)) {

                //show search results
                var elem = $(cats[i]).parent().parent().parent().get(0);
                $(elem).show();
            }
        }
    }



