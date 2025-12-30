const form= document.getElementById('Form');
const emailInput= document.getElementById('emailBox');
const passwordInput= document.getElementById('passwordBox') 
const fullNameInput= document.getElementById('fullNameBox');
const confirmPasswordInput= document.getElementById('confirmPasswordBox');
const errorMessages=document.getElementById('errorMessages');

form.addEventListener('submit', e => {
    let errors=[];
    if(fullNameInput){
        errors=getSignUpErrors(fullNameInput.value, emailInput.value, passwordInput.value, confirmPasswordInput.value);
    }
    else{
        errors=getLogInErrors(emailInput.value, passwordInput.value);
    }
    if (errors.length>0){
    e.preventDefault();
    errorMessages.innerText=errors.join('. ');
    errorMessages.style.color = "#d10000d3";
}
else{
    e.preventDefault();
    window.location.href='mvpHsCode.html';
}
});



function getSignUpErrors(fullName, email, password, confirmPassword){
    let errors=[];
    if(fullName === '' || fullName == null){
        errors.push('Full name is required.');
        fullNameInput.parentElement.parentElement.classList.add('incorrect');
    }
    if(fullName.length<3 && fullName!==""){
        errors.push('Full name must be at least 3 characters.');
        fullNameInput.parentElement.parentElement.classList.add('incorrect');
    }


    if(email === '' || email == null){
        errors.push('Email is required.');
        emailInput.parentElement.parentElement.classList.add('incorrect');
    }
    if((!email.includes('.')||!email.includes('@')) && email!==""){
        errors.push('Please enter a valid email address.');
        emailInput.parentElement.parentElement.classList.add('incorrect');
    }
    if(email.includes(' ')){
        errors.push('Email cannot contain spaces.');
        emailInput.parentElement.parentElement.classList.add('incorrect');
    }


    if(password === '' || password == null){
        errors.push('Password is required.');
        passwordInput.parentElement.parentElement.classList.add('incorrect');
    }
    
    if(password.length<8 && password!==""){
        errors.push('Password must be at least 8 characters');
        passwordInput.parentElement.parentElement.classList.add('incorrect');
    }
    
    if(password.includes(' ')){
        errors.push('Password cannot contain spaces.');
        passwordInput.parentElement.parentElement.classList.add('incorrect');
    }
    if(!/[A-Z]/.test(password))
    {
        errors.push('Password must contain at least one uppercase letter.');
        passwordInput.parentElement.parentElement.classList.add('incorrect');
    }


    if(confirmPassword === '' || confirmPassword == null){
        errors.push('Please confirm your password.');
        confirmPasswordInput.parentElement.parentElement.classList.add('incorrect');
    }
    if (password !== confirmPassword && confirmPassword!==""){ 
        errors.push('Passwords do not match');
        confirmPasswordInput.parentElement.parentElement.classList.add('incorrect');
    }
   
    return errors;
};
function getLogInErrors(email, password){
    let errors=[];
    if(email==='' || email==null){
        errors.push('Email is required.');
        emailInput.parentElement.parentElement.classList.add('incorrect');
    }
    if((!email.includes('.')||!email.includes('@')) && email!==""){
        errors.push('Please enter a valid email address.');
        emailInput.parentElement.parentElement.classList.add('incorrect');
    }
    if(email.includes(' ')){
        errors.push('Email cannot contain spaces.');
        emailInput.parentElement.parentElement.classList.add('incorrect');
    }


    if(password==='' || password==null){
        errors.push('Password is required.');
        passwordInput.parentElement.parentElement.classList.add('incorrect');
    }
    if(password.length<8 && password!==""){
        errors.push('Password must be at least 8 characters');
        passwordInput.parentElement.parentElement.classList.add('incorrect');
    }
    
    if(password.includes(' ')){
        errors.push('Password cannot contain spaces.');
        passwordInput.parentElement.parentElement.classList.add('incorrect');
    }
    
    if(!/[A-Z]/.test(password))
    {
        errors.push('Password must contain at least one uppercase letter.');
        passwordInput.parentElement.parentElement.classList.add('incorrect');
    }
    
    return errors;
};
const allInputs=[emailInput, passwordInput, fullNameInput, confirmPasswordInput];
allInputs.forEach(input => {
    if(!input) return;
    input.addEventListener('input', () => {
        if(input.parentElement.parentElement.classList.contains('incorrect')){
            input.parentElement.parentElement.classList.remove('incorrect');
            errorMessages.innerText='';
        }
    })
    });

const setupEyeToggle = (iconId, inputId) => {
    const icon = document.getElementById(iconId);
    const input = document.getElementById(inputId);

    if (icon && input) {
        icon.onclick = function() {
            if (input.type === 'password') {
                input.type = 'text';
                icon.src = 'icons/eye.png';
            } else {
                input.type = 'password';
                icon.src = 'icons/eyeOff.png';
            }
        };
    }
};

setupEyeToggle('eyeIcon', 'passwordBox');         
setupEyeToggle('eyeIcon1', 'passwordBox');        
setupEyeToggle('eyeIcon2', 'confirmPasswordBox'); 