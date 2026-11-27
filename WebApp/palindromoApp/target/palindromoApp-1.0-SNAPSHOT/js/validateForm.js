
const form = document.getElementById('palindromeForm');

form?.addEventListener('submit', async function(e) {
    e.preventDefault(); // Evita que no se recargue la pagina
    
    const textWordInput = document.getElementById('textWord').value.trim();
    const messagaResponse = document.getElementById('messageResponse');
    
    messagaResponse.textContent = "Procesando...";
    messagaResponse.className = "";
    
    if(!textWordInput){
        messagaResponse.textContent = "Error: El campo no puede estar vacío.";
        messagaResponse.className = "error";
        return;
    }
    
    const formData = new URLSearchParams();
    formData.append('word',textWordInput);
    
    try{
        // Petición al WebServlet
        
        var xhttp = new XMLHttpRequest();
        //const word = encodeURIComponent(formData);
        
        xhttp.open("POST", `palindrome?${formData}`, true);
        xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        
        
        xhttp.onload = function () {
            // readyState 4 = petición finalizada; status 200 = respuesta exitosa
            if (xhttp.readyState === 4) {
                if (xhttp.status === 200) {
                    const respuesta = JSON.parse(xhttp.responseText);
                    
                    messagaResponse.textContent = respuesta.mensaje;
                    messagaResponse.className = "success";
                    document.getElementById('palindromeForm').reset();
                    
                } else {
                    console.error("Error en la petición:", xhttp.status);
                }
            }
            
            xhttp.onerror = function () {
                console.error("Error de red al conectar con el servlet");
            };
            
        };
        xhttp.send();
        
    } catch (error) {
        console.log(error);
        messagaResponse.textContent = error.message;
        messagaResponse.className = "error";
    }
    
    
    
});
