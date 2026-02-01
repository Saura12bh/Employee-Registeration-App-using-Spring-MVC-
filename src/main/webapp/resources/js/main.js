function sr()
{
	let name = document.getElementById("name").value;

	    fetch("search?name=" + name)
	        .then(response => response.json())
	        .then(data => {
	            console.log(data);
	        });
}

