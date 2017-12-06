# os_rw_problem
[1061fall] OS final project

# Readers and Writers Problem
Here one has a system of r readers and w writers that all access a common database (or some other resource). A reader may share the resource with an unlimited number of other readers, but a writer must be in exclusive control of the resource. We call this the RW problem. Two additional constrains characterize variants of the problem. Find a solution to each of the following RW1 and RW2 problem, which does not cause starvation of readers and writers.

## Problem RW1
As soon as a writer is ready to write, no new reader should get permission to run. Starvation of readers is possibility here.

## Problem RW2
No writers is permitted to start running if there are any waiting readers. Here it is possible to starve the writers.
