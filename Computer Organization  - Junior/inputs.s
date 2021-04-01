	.data	# Data section
		# Assembler directive - does not result in code
        mystr: .ascii "Hello World! \n"
        qn:    .asciiz "What is your name?\n:"
        greet: .ascii "Welcome "
        intA: .word 7
        intB: .word 3

	.text	# text section, this is the section reserved for 
		# instructions
	.globl main	# declaration of the main function
			# an example of a lable
main:

lw $t0, intA #lw is load word
lw $t1, intB
add $t0, $t0, $t1

sw $t0, intA #sw is store word
addi, $v0, $zero, 1
lw $a0, intA
syscall

Exit: