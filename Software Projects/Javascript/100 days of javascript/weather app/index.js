const container = document.querySelector('.container');
const search = document.querySelector('.search-box button');
const weatherBox = document.querySelector('.weather-box');
const weatherDetails = document.querySelector('.weather-details');
const error404 = document.querySelector('.not-found');

search.addEventListener('click', () => {
    const APIKey = 'da9b8fea1e42050d771228e61fdb55ee'; // api key
    const city = document.querySelector('.search-box input').value;

    if(city === '') {
        return;
    }

    // make api call to get longitude and latitude of entered city
    fetch(`http://api.openweathermap.org/geo/1.0/direct?q=${city},&GB&limit=5&appid=${APIKey}`).then(response => response.json()).then(
        json => {
            lat = document.querySelector(`json[0].lat`);
            lon = document.querySelector(`json[0].lon`);

            fetch(`https://api.openweathermap.org/data/3.0/onecall?lat=${lat}&lon=${lon}&appid=${APIKey}`).then(response => response.json()).then
            (json => {
                
                // 404 not found
                if(json.code === '404') {
                    container.computedStyleMap.height = '400px';
                    weatherBox.style.display = 'none';
                    weatherDetails.style.display = 'none';
                    error404.style.display = 'block';
                    error404.classList.add('fadeIn');
                    return;
                }
        
                error404.style.display = 'none';
                error404.classList.remove('fadeIn');
        
                const image = document.querySelector('.weather-box img');
                const temperature = document.querySelector('.weather-box .temperature');
                const description = document.querySelector('.weather-box .description');
                const humidity = document.querySelector('.weather-details .humidity span');
                const wind = document.querySelector('.weather-details .wind span');
        
                switch(json.weather[0].main){
                    case 'Clear':
                        image.src = 'images/clear.png';
                        break;
        
                    case 'Rain':
                        image.src = 'images/rain.png';
                        break;
                    
                    case 'Snow':
                        image.src = 'images/snow.png';
                        break;
        
                    case 'Clouds':
                        image.src = 'images/clouds.png';
                        break;
                        
                    case 'Haze':
                        image.src = 'images/mist.png';
                        break;
        
                    default:
                        image.src = '';
                }
        
                temperature.innerHTML = `${parseInt(json.main.temp)}<span>℃</span>`;
                description.innerHTML = `${json.weather[0].description}`;
                humidity.innerHTML = `${json.main.humidity}%`;
                wind.innerHTML = `${json.main.wind.soeed}Km/h`;
        
                weatherBox.style.display = '';
                weatherDetails.style.display = '';
                weatherBox.classList.add('fadeIn');
                weatherDetails.classList.add('fadeIn');
                container.style.height = '590px';
            });
        });
        });


    // make api call to get city with longitude and latitude
   