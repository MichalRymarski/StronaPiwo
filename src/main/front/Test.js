const username = 'admin';
const password = 'admin';

fetch('http://localhost:8082/beers/example/Michas', {
    method: 'GET',
    headers: {
        'Authorization': 'Basic ' + btoa(username + ":" + password),
    }
})
    .then(response => response.json())
    .then(data => {
        // Get the div element
        var div = document.getElementById('beerData');

        // Iterate over each item in the data array
        data.forEach(item => {
            // Create an img element for the beer image
            var img = document.createElement('img');
            img.src = item.url;
            img.width = 200;
            img.height = 200;
            div.appendChild(img);

            // Create a p element for the beer description
            var p = document.createElement('p');
            p.textContent = item.description;
            div.appendChild(p);

            // Create a p element for the beer proposedBy
            var p2 = document.createElement('p');
            p2.textContent = "Proposed by: " + item.proposedBy;
            div.appendChild(p2);
        });
    })
    .catch(error => console.error('Error:', error));