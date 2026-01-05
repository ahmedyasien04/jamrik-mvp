document.getElementById('findHsCodeBox').addEventListener('click', async (e) => {
    e.preventDefault();
    
    const pName = document.getElementById('productNameBox').value;
    const pDesc = document.getElementById('productDescriptionBox').value;

    if (!pName || !pDesc) {
        alert("Please fill in both the Product Name and Description.");
        return;
    }

    const url = `http://localhost:8080/jamrik/hs?productName=${encodeURIComponent(pName)}&description=${encodeURIComponent(pDesc)}`;

    try {
        console.log("Calling backend...");
        const response = await fetch(url);
    if (response.ok) {
    const hsResult = await response.text();

    const resultSection = document.getElementById('resultSection');
    const productLabel = document.getElementById('resultProductLabel');
     const codeDisplay = document.getElementById('hsCodeDisplayBox');

            productLabel.innerText = `Suggested HS Code for: ${pName}`;
            codeDisplay.innerText = hsResult;

            resultSection.style.display = 'block';
} else {
    alert("Backend error. Status: " + response.status);
}
    } catch (error) {
        console.error("Connection failed:", error);
        alert("Cannot connect to the backend on port 8080.");
    }
});
