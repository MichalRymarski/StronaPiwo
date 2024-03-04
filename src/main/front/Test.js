const username = 'admin';
const password = 'admin';

fetch('http://localhost:8082/beers/example', {
    method: 'GET',
    headers: {
        'Authorization': 'Basic ' + btoa(username + ":" + password)
    }
})
    .then(response => response.json())
    .then(data => {
        // Get the div element
        var div = document.getElementById('beerData');

        // Create an img element for the beer image
        var img = document.createElement('img');
        img.src = data.url;
        div.appendChild(img);

        // Create a p element for the beer description
        var p = document.createElement('p');
        p.textContent = data.description;
        div.appendChild(p);

        // Create a p element for the beer proposedBy
        var p2 = document.createElement('p');
        p2.textContent = "Proposed by: " + data.proposedBy;
        div.appendChild(p2);
    })
    .catch(error => console.error('Error:', error));