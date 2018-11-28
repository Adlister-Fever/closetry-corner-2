(function () {
    $.get("https://api.openweathermap.org/data/2.5/weather", {
        APPID: "09be3d87503af2062f84723988428f58",
        q:     "San Antonio, US",
        units: "imperial"
    })
        .done(function (data) {
            console.log(data);
            let currentTemp = data.main.temp;
            let generalWeather = data.weather[0].main;
            let icon = data.weather[0].icon;
            $('#weather-box').append("<h5><img src='https://openweathermap.org/img/w/" + icon + ".png'/>" + " It is " + currentTemp + " degrees. " + generalWeather + " in " + data.name + "</h5>");

            if(currentTemp < 66){
                $('#weather-box').append("<p>You may need a jacket. Try searching for cold weather</p>");
            } else if(currentTemp >= 80){
                $('#weather-box').append("<p>You may need a hat or shades. Try searching for hot weather</p>");
            } else {
                $('#weather-box').append("<p>It's perfect outside. Search for whatever you want!</p>");
            }
            if(generalWeather == "Rain"){
                $('#weather-box').append("<p>Rain is in the forecast for today. You may need an umbrella</p>");
            } else if (generalWeather == "Snow"){
                $('#weather-box').append("<p>Snow is in the forecast for today. You may need a heavy jacket</p>");

            }

        });
})();
