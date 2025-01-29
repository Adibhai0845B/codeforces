def minimum_initial_ants(a):
    min_required = 0
    current_count = 0

    for ai in a:
        current_count += ai
        if current_count < 0:
            min_required += -current_count
            current_count = 0

    return min_required
