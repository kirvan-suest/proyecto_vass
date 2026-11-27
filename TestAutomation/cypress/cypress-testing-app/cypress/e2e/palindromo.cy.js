describe('Validacion de palabra', () => {
  
  it('Validacion de respuesta correcta, cuando la palabra es palindromo', () => {
    cy.visit('http://localhost:8080/palindromoApp/').viewport(1280, 800)
    let v_word = 'oso';  
    
    cy.get('[name="textWord"]').type(v_word);
    cy.get('[name="btnSend"]').click();
    cy.get('#messageResponse').should('have.text', '¡La palabra \''+v_word.toLowerCase()+'\' es palindomo.!');

  })

  it('Validacion de nombre de la clase \'success\', cuando la palabra no es valida', () => {
    cy.visit('http://localhost:8080/palindromoApp/').viewport(1280, 800)
    let v_word = 'kavak';  
    
    cy.get('[name="textWord"]').type(v_word);
    cy.get('[name="btnSend"]').click();
    cy.get('#messageResponse').should('have.class', 'success');
                                                    
  })

  it('Validacion de respuesta correcta, cuando la palabra no es palindromo', () => {
    cy.visit('http://localhost:8080/palindromoApp/').viewport(1280, 800)
    let v_word = 'Angel';  
    
    cy.get('[name="textWord"]').type(v_word);
    cy.get('[name="btnSend"]').click();
    cy.get('#messageResponse').should('have.text', '¡La palabra \''+v_word.toLowerCase()+'\' NO es palindomo.!');
                                                    
  })

  it('Validacion de mensaje de error, cuando la palabra no es valida', () => {
    cy.visit('http://localhost:8080/palindromoApp/').viewport(1280, 800)
    let v_word = '  ';  
    
    cy.get('[name="textWord"]').type(v_word);
    cy.get('[name="btnSend"]').click();
    cy.get('#messageResponse').should('have.text', 'Error: El campo no puede estar vacío.');
                                                    
  })

    it('Validacion de nombre de la clase \'error\', cuando la palabra no es valida', () => {
    cy.visit('http://localhost:8080/palindromoApp/').viewport(1280, 800)
    let v_word = '  ';  
    
    cy.get('[name="textWord"]').type(v_word);
    cy.get('[name="btnSend"]').click();
    cy.get('#messageResponse').should('have.class', 'error');
                                                    
  })

  it('Validacion de palabra larga con espacios', () => {
    cy.visit('http://localhost:8080/palindromoApp/').viewport(1280, 800)
    let v_word = 'Anita lava la tina';  
    
    cy.get('[name="textWord"]').type(v_word);
    cy.get('[name="btnSend"]').click();
    cy.get('#messageResponse').should('have.text', '¡La palabra \''+v_word.toLowerCase()+'\' es palindomo.!');
                                                    
  })
  

})